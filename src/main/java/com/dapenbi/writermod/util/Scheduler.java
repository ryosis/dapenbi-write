package com.dapenbi.writermod.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dapenbi.writermod.model.TRegisterDapenbi;
import com.dapenbi.writermod.nio.ControlFile;
import com.dapenbi.writermod.repository.TRegisterDapenbiRepository;
import com.dapenbi.writermod.service.TRegisterDapenbiService;

@Component
public class Scheduler {
	@Value("${doc.path}")
	private String docPath;

	@Autowired
	TRegisterDapenbiRepository tregdbiRepo;
	
	@Autowired
	TRegisterDapenbiService tregdbiService;

	private Logger log;	

	@Scheduled(cron = "* * * * * *")
	public void cronJobSch() {
		log = Logger.getLogger("com.dapenbi.writermod.util()");

		ControlFile controlFileObj = new ControlFile(docPath);

		List<TRegisterDapenbi> tmpList = tregdbiRepo.findByIsgenerate("0");
		
		try {
			controlFileObj.setLockFile();
			if (controlFileObj.isFileLocked()) {
				File file = new File(docPath);
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br);

				controlFileObj.setUnlockFile();
				for (TRegisterDapenbi tempObj : tmpList) {
					String dob = "";
					try {
						dob = tempObj.getDob().toString();	
					} catch (NullPointerException e) {
						// TODO: handle exception
					}
					
					pr.println(tempObj.getNip() + "," + tempObj.getFullname() + "," + dob + "," + tempObj.getGender()
							+ "," + tempObj.getAddress() + "," + tempObj.getIdnumber() + ","
							+ tempObj.getPhonenumber());
					
					List<TRegisterDapenbi> tmpListOne = tregdbiRepo.findByNip(tempObj.getNip());
					tregdbiService.updateDataGenerate(tmpListOne.get(0),"1");					
					
//					tregdbiRepo.deleteByNip(tempObj.getNip());
				}

				pr.close();
				br.close();
				fr.close();
			} else {
				System.out.println("not locked");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}	

}