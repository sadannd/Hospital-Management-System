<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">FIRSTNAME</th>
							<th scope="col">LASTNAME</th>
							<th scope="col">DOB</th>
							<th scope="col">GENDER</th>
							<th scope="col">EMAIL</th>
							<th scope="col">PHONE</th>
							<th scope="col">ADDRESS</th>
							<th scope="col">SSN</th>
							<th scope="col">COVIDSTATUS</th>
							<th scope="col">INSURANCEID</th>
						</tr>
					</thead>
					<tbody>
						<%
						AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
						DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
						List<User> list = dao.getAllAppointment();
						for (User ap : list) {
							//Doctor d = dao2.getDoctorById(ap.getDoctorId());
						%>
						<tr>
							<th><%=ap.getFIRSTNAME()%></th>
							<td><%=ap.getLASTNAME()%></td>
							<td><%=ap.getDOB()%></td>
							<td><%=ap.getGENDER()%></td>
							<td><%=ap.getEMAIL()%></td>
							<td><%=ap.getPHONE()%></td>
							<td><%=ap.getADDRESS()%></td>
							<td><%=ap.getSSN()%></td>
							<td><%=ap.getCOVIDSTATUS()%></td>
							<td><%=ap.getINSURANCEID()%></td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>