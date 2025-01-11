CREATE DATABASE test;
CREATE TABLE Triage (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        date DATE NOT NULL,
                        bloodPressure INT NOT NULL,
                        heartRate INT NOT NULL,
                        oxygenSaturation INT NOT NULL,
                        description TEXT
);

CREATE TABLE Queue (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       triageId INT NOT NULL,
                       priorityPoints INT NOT NULL,
                       priorityLevel ENUM('low', 'medium', 'high') NOT NULL DEFAULT 'low',
                       status ENUM('pending', 'in progress', 'completed') NOT NULL DEFAULT 'pending',
                       FOREIGN KEY (triageId) REFERENCES Triage(id) ON DELETE CASCADE
);

CREATE TABLE Visit (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       hospitalizationSteps TEXT NOT NULL,
                       prescription TEXT NOT NULL
);

CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       passwordHash VARCHAR(255) NOT NULL,
                       role ENUM('doctor', 'nurse', 'admin') NOT NULL,
                       fullName VARCHAR(100) NOT NULL,
                       email VARCHAR(100),
                       phoneNumber VARCHAR(20),
                       createdAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Doctors (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         userId INT NOT NULL,
                         specialty VARCHAR(100),
                         yearsOfExperience INT,
                         availabilityStatus ENUM('available', 'on leave', 'busy') DEFAULT 'available',
                         FOREIGN KEY (userId) REFERENCES Users(id) ON DELETE CASCADE
);

CREATE TABLE Patients (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          surname VARCHAR(100) NOT NULL,
                          dateOfBirth DATE NOT NULL,
                          gender ENUM('male', 'female', 'other') NOT NULL,
                          phoneNumber VARCHAR(20),
                          email VARCHAR(100),
                          address TEXT,
                          emergencyContactName VARCHAR(100),
                          emergencyContactPhone VARCHAR(20),
                          medicalHistory TEXT,
                          status ENUM('queued', 'admitted', 'released') DEFAULT 'queued',
                          createdAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Appointments (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              patientId INT NOT NULL,
                              doctorId INT NOT NULL,
                              appointmentDate DATETIME NOT NULL,
                              reasonForVisit TEXT,
                              status ENUM('scheduled', 'completed', 'cancelled') DEFAULT 'scheduled',
                              FOREIGN KEY (patientId) REFERENCES Patients(id) ON DELETE CASCADE,
                              FOREIGN KEY (doctorId) REFERENCES Doctors(id) ON DELETE CASCADE
);

CREATE TABLE Medications (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             description TEXT,
                             dosage VARCHAR(50),
                             sideEffects TEXT
);

CREATE TABLE Prescriptions (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               visitId INT NOT NULL,
                               medicationId INT NOT NULL,
                               quantity INT NOT NULL,
                               dosageInstructions TEXT,
                               prescribedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (visitId) REFERENCES Visit(id) ON DELETE CASCADE,
                               FOREIGN KEY (medicationId) REFERENCES Medications(id) ON DELETE CASCADE
);

CREATE TABLE Rooms (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       roomNumber VARCHAR(10) NOT NULL UNIQUE,
                       type ENUM('general', 'icu', 'private') NOT NULL,
                       capacity INT NOT NULL,
                       occupiedBeds INT DEFAULT 0,
                       CHECK (occupiedBeds <= capacity)
);
