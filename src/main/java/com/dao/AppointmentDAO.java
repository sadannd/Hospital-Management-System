package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;
import com.entity.User;

public class AppointmentDAO {

	private Connection conn;

	public AppointmentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;

		try {

			String sql = "insert into appointment(user_id,fullname,gender,age,appoint_date,email,phno,diseases,doctor_id,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ap.getAID());
			ps.setString(2, ap.getPATIENTID());
			ps.setString(3, ap.getDOCTORID());
			ps.setString(4, ap.getROOMID());
			ps.setString(5, ap.getDIAGNOSIS());
			ps.setString(6, ap.getPDATE());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setAID(rs.getString(1));
				ap.setPATIENTID(rs.getString(2));
				ap.setDOCTORID(rs.getString(3));
				ap.setROOMID(rs.getString(4));
				ap.setDIAGNOSIS(rs.getString(5));
				ap.setPDATE(rs.getString(6));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setAID(rs.getString(1));
				ap.setPATIENTID(rs.getString(2));
				ap.setDOCTORID(rs.getString(3));
				ap.setROOMID(rs.getString(4));
				ap.setDIAGNOSIS(rs.getString(5));
				ap.setPDATE(rs.getString(6));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Appointment getAppointmentById(int id) {

		Appointment ap = null;

		try {

			String sql = "select * from appointment where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setAID(rs.getString(1));
				ap.setPATIENTID(rs.getString(2));
				ap.setDOCTORID(rs.getString(3));
				ap.setROOMID(rs.getString(4));
				ap.setDIAGNOSIS(rs.getString(5));
				ap.setPDATE(rs.getString(6));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}

	public boolean updateCommentStatus(int id, int doctId, String comm) {
		boolean f = false;
		try {
			String sql = "update appointment set status=? where id=? and doctor_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<User> getAllAppointment() {
		List<User> list = new ArrayList<User>();
		User ap = null;

		try {

			String sql = "select * from PATIENT";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new User();
				ap.setPATIENTID(rs.getString(1));
				ap.setFIRSTNAME(rs.getString(2));
				ap.setLASTNAME(rs.getString(3));
				ap.setDOB(rs.getString(4));
				ap.setGENDER(rs.getString(5));
				ap.setEMAIL(rs.getString(6));
				ap.setPHONE(rs.getString(7));
				ap.setADDRESS(rs.getString(8));
				ap.setSSN(rs.getString(9));
				ap.setCOVIDSTATUS(rs.getString(10));
				ap.setINSURANCEID(rs.getString(11));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}