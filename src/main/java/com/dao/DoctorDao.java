package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerDoctor(Doctor d) {
		boolean f = false;
		d.setId(45);
		try {
			String sql = "update doctorview1 set DDOB=?,DOCLICENSEID=?,SHIFTID=?,DEMAIL=?,DNAME=?,QUALIFICATION=?,SPECIALIZATION=?,DPASS=?,DPHONE=? where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDob());
			ps.setString(2, d.getLicenseID());
			ps.setInt(3, Integer.parseInt(d.getShiftID()));
			ps.setString(4, d.getEmail());
			ps.setString(5, d.getFullName());
			ps.setString(6, d.getQualification());
			ps.setString(7, d.getSpecialist());
			ps.setString(8, d.getPassword());
			ps.setString(9, d.getMobNo());
			ps.setInt(10, d.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {

			String sql = "select * from doctorview1 order by DOCTORID desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setDob(rs.getString(2));
				d.setLicenseID(rs.getString(3));
				d.setShiftID(String.valueOf(rs.getInt(4)));
				d.setEmail(rs.getString(5));
				d.setFullName(rs.getString(6));
				d.setQualification(rs.getString(7));
				d.setSpecialist(rs.getString(8));
				d.setPassword(rs.getString(9));
				d.setMobNo(String.valueOf(rs.getString(10)));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorById(int id) {

		Doctor d = null;
		try {

			String sql = "select * from doctor where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setDob(rs.getString(2));
				d.setLicenseID(rs.getString(3));
				d.setShiftID(String.valueOf(rs.getInt(4)));
				d.setEmail(rs.getString(5));
				d.setFullName(rs.getString(6));
				d.setQualification(rs.getString(7));
				d.setSpecialist(rs.getString(8));
				d.setPassword(rs.getString(9));
				d.setMobNo(String.valueOf(rs.getString(10)));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean updateDoctor(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctorview1 set DDOB=?,DOCLICENSEID=?,SHIFTID=?,DEMAIL=?,DNAME=?,QUALIFICATION=?,SPECIALIZATION=?,DPASS=?,DPHONE=? where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDob());
			ps.setString(2, d.getLicenseID());
			ps.setInt(3, Integer.parseInt(d.getShiftID()));
			ps.setString(4, d.getEmail());
			ps.setString(5, d.getFullName());
			ps.setString(6, d.getQualification());
			ps.setString(7, d.getSpecialist());
			ps.setString(8, d.getPassword());
			ps.setString(9, d.getMobNo());
			ps.setInt(10, d.getId());
			//System.out.println("id in doctor:-"+d.getId());
			//ps.setInt(10, 45);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteDoctor(int id) {
		boolean f = false;
		try {
			String sql = "delete from doctorview1 where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public Doctor login(String email, String psw) {
		Doctor d = null;
		try {

			String sql = "select * from doctorview1 where DEMAIL=? and DPASS=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointmentByDocotrId(int did) {
		int i = 0;
		try {
			String sql = "select * from appointment where DOCTORID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countUSer() {
		int i = 0;
		try {
			String sql = "select * from user_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor where id=? and password=?";
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
			String sql = "update doctor set password=? where id=?";
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

	public boolean editDoctorProfile(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setInt(7, d.getId());
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