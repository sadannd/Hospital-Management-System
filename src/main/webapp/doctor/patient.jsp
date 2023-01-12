<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
	<c:if test="${empty doctObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
							<th scope="col">AID</th>
							<th scope="col">PATIENTID</th>
							<th scope="col">ROOMID</th>
							<th scope="col">DIAGNOSIS</th>
							<th scope="col">PDATE</th>
							
								</tr>
							</thead>
							<tbody>
								<%
								Doctor d = (Doctor) session.getAttribute("doctObj");
								AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
								List<Appointment> list = dao.getAllAppointmentByDoctorLogin(d.getId());
								for (Appointment ap : list) {
								%>
								<tr>
							<th><%=ap.getAID()%></th>
							<td><%=ap.getPATIENTID()%></td>
							<td><%=ap.getROOMID()%></td>
							<td><%=ap.getDIAGNOSIS()%></td>
							<td><%=ap.getPDATE()%></td>
							

								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>



</body>
</html>