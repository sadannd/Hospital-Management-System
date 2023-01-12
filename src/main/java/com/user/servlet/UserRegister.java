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

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String FIRSTNAME = req.getParameter("FIRSTNAME");
			String LASTNAME = req.getParameter("LASTNAME");
			String DOB = req.getParameter("DOB");
			String GENDER = req.getParameter("GENDER");
			String PHONE = req.getParameter("PHONE");
			String ADDRESS = req.getParameter("ADDRESS");
			String SSN = req.getParameter("SSN");
			String COVIDSTATUS = req.getParameter("COVIDSTATUS");
			String INSURANCEID = req.getParameter("INSURANCEID");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			//String PATIENTID=req.getParameter("PATIENTID");
			String PATIENTID="1";

			User u = new User(PATIENTID,FIRSTNAME,LASTNAME,DOB,GENDER, email,PHONE,ADDRESS,SSN,COVIDSTATUS ,INSURANCEID);

			UserDao dao = new UserDao(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean f = dao.register(u);

			if (f) {

				session.setAttribute("sucMsg", "Register Sucessfully");
				resp.sendRedirect("signup.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}