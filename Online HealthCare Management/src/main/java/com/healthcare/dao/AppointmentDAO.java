package com.healthcare.dao;

import com.healthcare.models.Appointment;
import com.healthcare.utils.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO implements DAO<Appointment> {

    @Override
    public Appointment findById(int id) throws Exception {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Appointment a = new Appointment();
                    a.setId(rs.getInt("id"));
                    a.setPatientId(rs.getInt("patient_id"));
                    a.setDoctorId(rs.getInt("doctor_id"));
                    a.setAppointmentTime(rs.getTimestamp("appointment_time").toLocalDateTime());
                    a.setStatus(rs.getString("status"));
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public List<Appointment> findAll() throws Exception {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments ORDER BY appointment_time DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Appointment a = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getTimestamp("appointment_time").toLocalDateTime(),
                        rs.getString("status"));
                list.add(a);
            }
        }
        return list;
    }

    @Override
    public boolean save(Appointment a) throws Exception {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_time, status) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(a.getAppointmentTime()));
            ps.setString(4, a.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(Appointment a) throws Exception {
        String sql = "UPDATE appointments SET patient_id=?, doctor_id=?, appointment_time=?, status=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(a.getAppointmentTime()));
            ps.setString(4, a.getStatus());
            ps.setInt(5, a.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
