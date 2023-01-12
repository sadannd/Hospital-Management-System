package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean register(User u) {
		boolean f = false;
		System.out.println("in register");
		System.out.println();
		try {
			String sql = "insert into HOSPITAL.PATIENT(PATIENTID,FIRSTNAME,LASTNAME,DOB,GENDER,EMAIL,PHONE,ADDRESS,SSN,COVIDSTATUS,INSURANCEID) values(?,?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "P03001");
			ps.setString(2, u.getFIRSTNAME());
			ps.setString(3, u.getLASTNAME());
			ps.setString(4, u.getDOB());
			ps.setString(5, u.getGENDER());
			ps.setString(6, u.getEMAIL());
			ps.setString(7, u.getPHONE());
			ps.setString(8, u.getADDRESS());
			ps.setString(9, u.getSSN());
			ps.setString(10, u.getCOVIDSTATUS());
			ps.setString(11, u.getINSURANCEID());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public User login(String em, String psw) {
		User u = null;
		System.out.println("email is"+em);
		try {
			String sql = "select * from patient where EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("in resultset");
				u = new User();
				u.setPATIENTID(rs.getString(1));
				u.setFIRSTNAME(rs.getString(2));
				u.setLASTNAME(rs.getString(3));
				u.setDOB(rs.getString(4));
				u.setGENDER(rs.getString(5));
				u.setEMAIL(rs.getString(6));
				u.setPHONE(rs.getString(7));
				u.setADDRESS(rs.getString(8));
				u.setSSN(rs.getString(9));
				u.setCOVIDSTATUS(rs.getString(10));
				u.setINSURANCEID(rs.getString(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from user_dtls where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update user_dtls set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}