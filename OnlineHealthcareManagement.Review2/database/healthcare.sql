
CREATE DATABASE healthcare;
USE healthcare;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  password VARCHAR(50),
  role VARCHAR(20)
);

CREATE TABLE appointments (
  appointment_id INT AUTO_INCREMENT PRIMARY KEY,
  patient VARCHAR(50),
  doctor VARCHAR(50),
  date VARCHAR(20)
);

INSERT INTO users(username,password,role) VALUES
('admin','admin','ADMIN'),
('patient','patient','PATIENT'),
('doctor','doctor','DOCTOR');
