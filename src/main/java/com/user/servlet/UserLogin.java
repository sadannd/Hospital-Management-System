package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		UserDao dao = new UserDao(DBConnect.getConn());
		User user = dao.login(email, password);
		System.out.println("USerLogin complete");
		if (user != null) {
			System.out.println("1");
			session.setAttribute("fullname", user.getFIRSTNAME());
			session.setAttribute("gender", user.getGENDER());
			session.setAttribute("age", user.getDOB());
			session.setAttribute("email", user.getEMAIL());
			session.setAttribute("phoneno", user.getPHONE());
			session.setAttribute("addr", user.getADDRESS());
		
			resp.sendRedirect("user_appointment.jsp");
			
		} else {
			System.out.println("2");
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("user_login.jsp");
		}

	}

}