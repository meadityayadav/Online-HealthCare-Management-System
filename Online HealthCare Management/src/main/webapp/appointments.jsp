<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.healthcare.models.Appointment"%>
<html><head><title>Appointments</title></head><body>
<h2>Appointments</h2>
<table border="1">
  <tr><th>ID</th><th>Patient ID</th><th>Doctor ID</th><th>Time</th><th>Status</th></tr>
  <%
    List<Appointment> list = (List<Appointment>) request.getAttribute("appointments");
    if (list != null) {
        for (Appointment a : list) {
  %>
  <tr>
    <td><%=a.getId()%></td>
    <td><%=a.getPatientId()%></td>
    <td><%=a.getDoctorId()%></td>
    <td><%=a.getAppointmentTime()%></td>
    <td><%=a.getStatus()%></td>
  </tr>
  <%      }
    } %>
</table>
<h3>Book Appointment</h3>
<form method="post" action="appointments">
  Patient ID: <input name="patient_id" required /><br/>
  Doctor ID: <input name="doctor_id" required /><br/>
  Time (YYYY-MM-DDTHH:MM:SS): <input name="appointment_time" required /><br/>
  <button type="submit">Book</button>
</form>
</body></html>
