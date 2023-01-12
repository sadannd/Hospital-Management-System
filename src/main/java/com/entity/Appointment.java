package com.entity;

public class Appointment {
	//private int id;
	private String AID;
	public String getAID() {
		return AID;
	}

	public void setAID(String aID) {
		AID = aID;
	}

	public String getPATIENTID() {
		return PATIENTID;
	}

	public void setPATIENTID(String pATIENTID) {
		PATIENTID = pATIENTID;
	}

	public String getDOCTORID() {
		return DOCTORID;
	}

	public void setDOCTORID(String dOCTORID) {
		DOCTORID = dOCTORID;
	}

	public String getROOMID() {
		return ROOMID;
	}

	public void setROOMID(String rOOMID) {
		ROOMID = rOOMID;
	}

	public String getDIAGNOSIS() {
		return DIAGNOSIS;
	}

	public void setDIAGNOSIS(String dIAGNOSIS) {
		DIAGNOSIS = dIAGNOSIS;
	}

	public String getPDATE() {
		return PDATE;
	}

	public void setPDATE(String pDATE) {
		PDATE = pDATE;
	}

	private String PATIENTID;
	private String DOCTORID;
	private String ROOMID;
	private String DIAGNOSIS;
	private String PDATE;
	




	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(String AID, String PATIENTID, String DOCTORID, String ROOMID, String DIAGNOSIS, String PDATE) {
		super();
		this.AID = AID;
		this.PATIENTID = PATIENTID;
		this.DOCTORID = DOCTORID;
		this.ROOMID = ROOMID;
		this.DIAGNOSIS = DIAGNOSIS;
		this.PDATE = PDATE;

	}


}