package com.healthcare.servlets;

import com.healthcare.dao.AppointmentDAO;
import com.healthcare.models.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/appointments")
public class AppointmentServlet extends HttpServlet {
    private AppointmentDAO dao = new AppointmentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("appointments", dao.findAll());
            req.getRequestDispatcher("/appointments.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int patientId = Integer.parseInt(req.getParameter("patient_id"));
            int doctorId = Integer.parseInt(req.getParameter("doctor_id"));
            LocalDateTime time = LocalDateTime.parse(req.getParameter("appointment_time"));
            Appointment a = new Appointment();
            a.setPatientId(patientId);
            a.setDoctorId(doctorId);
            a.setAppointmentTime(time);
            a.setStatus("PENDING");
            dao.save(a);
            resp.sendRedirect(req.getContextPath() + "/appointments"); 
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
