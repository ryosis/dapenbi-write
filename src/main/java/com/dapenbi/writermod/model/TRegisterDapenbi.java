package com.dapenbi.writermod.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_register_dapenbi database table.
 * 
 */
@Entity
@Table(name="t_register_dapenbi")
@NamedQuery(name="TRegisterDapenbi.findAll", query="SELECT t FROM TRegisterDapenbi t")
public class TRegisterDapenbi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nip;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String fullname;

	private String gender;

	private String idnumber;

	private String isgenerate;

	private String phonenumber;

	public TRegisterDapenbi() {
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getIsgenerate() {
		return this.isgenerate;
	}

	public void setIsgenerate(String isgenerate) {
		this.isgenerate = isgenerate;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}