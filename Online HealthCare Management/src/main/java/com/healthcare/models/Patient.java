package com.healthcare.models;

import java.sql.Date;

public class Patient extends User {
    private int patientId;
    private Date dob;
    private String gender;
    private String phone;

    public Patient(){}

    public Patient(int id, String username, String password, String role, String fullName, String email,
                   int patientId, Date dob, String gender, String phone) {
        super(id, username, password, role, fullName, email);
        this.patientId = patientId; this.dob = dob; this.gender = gender; this.phone = phone;
    }

    public int getPatientId(){ return patientId; }
    public void setPatientId(int patientId){ this.patientId = patientId; }
    public Date getDob(){ return dob; }
    public void setDob(Date dob){ this.dob = dob; }
    public String getGender(){ return gender; }
    public void setGender(String gender){ this.gender = gender; }
    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }
}
