package com.healthcare.models;

public class Doctor extends User {
    private int doctorId; // doctors table id
    private String specialty;
    private String phone;

    public Doctor(){}

    public Doctor(int id, String username, String password, String role, String fullName, String email,
                  int doctorId, String specialty, String phone) {
        super(id, username, password, role, fullName, email);
        this.doctorId = doctorId; this.specialty = specialty; this.phone = phone;
    }

    public int getDoctorId(){ return doctorId; }
    public void setDoctorId(int doctorId){ this.doctorId = doctorId; }
    public String getSpecialty(){ return specialty; }
    public void setSpecialty(String specialty){ this.specialty = specialty; }
    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }
}
