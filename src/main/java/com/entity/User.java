package com.entity;

public class User {
	private String PATIENTID;
	public String getPATIENTID() {
		return PATIENTID;
	}

	public void setPATIENTID(String pATIENTID) {
		PATIENTID = pATIENTID;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getCOVIDSTATUS() {
		return COVIDSTATUS;
	}

	public void setCOVIDSTATUS(String cOVIDSTATUS) {
		COVIDSTATUS = cOVIDSTATUS;
	}

	private String FIRSTNAME;
	private String LASTNAME;
	private String DOB;
	private String GENDER;
	private String EMAIL;
	private String PHONE;
	private String ADDRESS;
	private String SSN;
	private String COVIDSTATUS;
	private String INSURANCEID;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String PATIENTID, String FIRSTNAME, String LASTNAME, String DOB, String GENDER, String EMAIL,
			String PHONE, String ADDRESS, String SSN, String COVIDSTATUS, String INSURANCEID) {
		super();
		this.PATIENTID = PATIENTID;
		this.FIRSTNAME = FIRSTNAME;
		this.LASTNAME = LASTNAME;
		this.DOB = DOB;
		this.GENDER = GENDER;
		this.EMAIL = EMAIL;
		this.PHONE = PHONE;
		this.ADDRESS = ADDRESS;
		this.SSN = SSN;
		this.COVIDSTATUS = COVIDSTATUS;
		this.setINSURANCEID(INSURANCEID);
	}

	public String getINSURANCEID() {
		return INSURANCEID;
	}

	public void setINSURANCEID(String iNSURANCEID) {
		INSURANCEID = iNSURANCEID;
	}

}