INSERT INTO Triage (name, date, bloodPressure, heartRate, oxygenSaturation, description)
VALUES
    ('John Doe', '2025-01-01', 120, 80, 98, 'Routine check-up'),
    ('Jane Smith', '2025-01-02', 140, 90, 96, 'Symptoms of fever and cough'),
    ('Alice Johnson', '2025-01-03', 130, 85, 99, 'Headache and fatigue'),
    ('Bob Brown', '2025-01-04', 125, 88, 97, 'Follow-up visit for hypertension'),
    ('Chris Evans', '2025-01-05', 110, 75, 100, 'Routine heart check-up'),
    ('Diana Prince', '2025-01-06', 145, 95, 92, 'Severe headache and nausea'),
    ('Bruce Wayne', '2025-01-07', 115, 70, 98, 'Follow-up visit after surgery'),
    ('Clark Kent', '2025-01-08', 135, 85, 95, 'Symptoms of dizziness and fatigue'),
    ('Natasha Romanoff', '2025-01-09', 130, 88, 97, 'General consultation'),
    ('Steve Rogers', '2025-01-10', 120, 80, 100, 'Routine physical check-up'),
    ('Jane Smith', '2025-01-02', 140, 90, 96, 'Symptoms of fever and cough'),
    ('Alice Johnson', '2025-01-03', 130, 85, 99, 'Headache and fatigue'),
    ('Bob Brown', '2025-01-04', 125, 88, 97, 'Follow-up visit for hypertension'),
    ('Chris Evans', '2025-01-05', 110, 75, 100, 'Routine heart check-up'),
    ('Diana Prince', '2025-01-06', 145, 95, 92, 'Severe headache and nausea'),
    ('Bruce Wayne', '2025-01-07', 115, 70, 98, 'Follow-up visit after surgery'),
    ('Clark Kent', '2025-01-08', 135, 85, 95, 'Symptoms of dizziness and fatigue'),
    ('Natasha Romanoff', '2025-01-09', 130, 88, 97, 'General consultation'),
    ('Steve Rogers', '2025-01-10', 120, 80, 100, 'Routine physical check-up'),
    ('Jane Smith', '2025-01-02', 140, 90, 96, 'Symptoms of fever and cough'),
    ('Alice Johnson', '2025-01-03', 130, 85, 99, 'Headache and fatigue'),
    ('Bob Brown', '2025-01-04', 125, 88, 97, 'Follow-up visit for hypertension'),
    ('Chris Evans', '2025-01-05', 110, 75, 100, 'Routine heart check-up'),
    ('Diana Prince', '2025-01-06', 145, 95, 92, 'Severe headache and nausea'),
    ('Bruce Wayne', '2025-01-07', 115, 70, 98, 'Follow-up visit after surgery'),
    ('Clark Kent', '2025-01-08', 135, 85, 95, 'Symptoms of dizziness and fatigue'),
    ('Natasha Romanoff', '2025-01-09', 130, 88, 97, 'General consultation'),
    ('Steve Rogers', '2025-01-10', 120, 80, 100, 'Routine physical check-up');


INSERT INTO Queue (triageId, priorityPoints, priorityLevel, status)
VALUES
    (1, 85, 'high', 'pending'),
    (2, 70, 'medium', 'in progress'),
    (3, 40, 'low', 'pending'),
    (4, 95, 'high', 'completed'),
    (5, 50, 'medium', 'pending'),
    (6, 30, 'low', 'in progress'),
    (7, 75, 'medium', 'pending'),
    (8, 90, 'high', 'completed'),
    (9, 45, 'low', 'pending'),
    (10, 60, 'medium', 'in progress'),
    (2, 70, 'medium', 'in progress'),
    (3, 40, 'low', 'pending'),
    (4, 95, 'high', 'completed'),
    (5, 50, 'medium', 'pending'),
    (6, 30, 'low', 'in progress'),
    (7, 75, 'medium', 'pending'),
    (8, 90, 'high', 'completed'),
    (9, 45, 'low', 'pending'),
    (10, 60, 'medium', 'in progress'),
    (2, 70, 'medium', 'in progress'),
    (3, 40, 'low', 'pending'),
    (4, 95, 'high', 'completed'),
    (5, 50, 'medium', 'pending'),
    (6, 30, 'low', 'in progress'),
    (7, 75, 'medium', 'pending'),
    (8, 90, 'high', 'completed'),
    (9, 45, 'low', 'pending'),
    (10, 60, 'medium', 'in progress'),
    (2, 70, 'medium', 'in progress'),
    (3, 40, 'low', 'pending'),
    (4, 95, 'high', 'completed'),
    (5, 50, 'medium', 'pending'),
    (6, 30, 'low', 'in progress'),
    (7, 75, 'medium', 'pending'),
    (8, 90, 'high', 'completed'),
    (9, 45, 'low', 'pending'),
    (10, 60, 'medium', 'in progress');

INSERT INTO Users (username, passwordHash, role, fullName, email, phoneNumber)
VALUES
    ('jdoe', 'hashed_password_1', 'doctor', 'Dr. John Doe', 'jdoe@example.com', '555-1234'),
    ('asmith', 'hashed_password_2', 'nurse', 'Alice Smith', 'asmith@example.com', '555-5678'),
    ('bbrown', 'hashed_password_3', 'admin', 'Bob Brown', 'bbrown@example.com', '555-9876'),
    ('cevens', 'hashed_password_4', 'doctor', 'Dr. Chris Evans', 'cevens@example.com', '555-4567'),
    ('dprince', 'hashed_password_5', 'nurse', 'Diana Prince', 'dprince@example.com', '555-6789'),
    ('bwayne', 'hashed_password_6', 'admin', 'Bruce Wayne', 'bwayne@example.com', '555-2468'),
    ('ckent', 'hashed_password_7', 'doctor', 'Dr. Clark Kent', 'ckent@example.com', '555-1357'),
    ('nromanoff', 'hashed_password_8', 'nurse', 'Natasha Romanoff', 'nromanoff@example.com', '555-9876'),
    ('srogers', 'hashed_password_9', 'admin', 'Steve Rogers', 'srogers@example.com', '555-5432');

INSERT INTO Medications (name, description, dosage, sideEffects)
VALUES
    ('Paracetamol', 'Pain reliever and fever reducer', '500mg every 6 hours', 'Nausea, rash'),
    ('Aspirin', 'Anti-inflammatory and blood thinner', '325mg daily', 'Stomach upset, bleeding'),
    ('Amoxicillin', 'Antibiotic for bacterial infections', '250mg every 8 hours', 'Diarrhea, allergic reactions'),
    ('Metoprolol', 'Beta-blocker for high blood pressure', '50mg daily', 'Fatigue, dizziness'),
    ('Ibuprofen', 'Anti-inflammatory for pain relief', '400mg every 8 hours', 'Stomach upset, rash'),
    ('Losartan', 'Blood pressure medication', '50mg daily', 'Dizziness, fatigue'),
    ('Atorvastatin', 'Lowers cholesterol', '10mg daily', 'Muscle pain, weakness'),
    ('Ciprofloxacin', 'Antibiotic for bacterial infections', '500mg every 12 hours', 'Nausea, diarrhea'),
    ('Omeprazole', 'Reduces stomach acid', '20mg daily', 'Headache, stomach pain'),
    ('Clopidogrel', 'Prevents blood clots', '75mg daily', 'Bleeding, rash'),
    ('Amoxicillin', 'Antibiotic for bacterial infections', '250mg every 8 hours', 'Diarrhea, allergic reactions'),
    ('Metoprolol', 'Beta-blocker for high blood pressure', '50mg daily', 'Fatigue, dizziness'),
    ('Ibuprofen', 'Anti-inflammatory for pain relief', '400mg every 8 hours', 'Stomach upset, rash'),
    ('Losartan', 'Blood pressure medication', '50mg daily', 'Dizziness, fatigue'),
    ('Atorvastatin', 'Lowers cholesterol', '10mg daily', 'Muscle pain, weakness'),
    ('Ciprofloxacin', 'Antibiotic for bacterial infections', '500mg every 12 hours', 'Nausea, diarrhea'),
    ('Omeprazole', 'Reduces stomach acid', '20mg daily', 'Headache, stomach pain'),
    ('Clopidogrel', 'Prevents blood clots', '75mg daily', 'Bleeding, rash'),
    ('Amoxicillin', 'Antibiotic for bacterial infections', '250mg every 8 hours', 'Diarrhea, allergic reactions'),
    ('Metoprolol', 'Beta-blocker for high blood pressure', '50mg daily', 'Fatigue, dizziness'),
    ('Ibuprofen', 'Anti-inflammatory for pain relief', '400mg every 8 hours', 'Stomach upset, rash'),
    ('Losartan', 'Blood pressure medication', '50mg daily', 'Dizziness, fatigue'),
    ('Atorvastatin', 'Lowers cholesterol', '10mg daily', 'Muscle pain, weakness'),
    ('Ciprofloxacin', 'Antibiotic for bacterial infections', '500mg every 12 hours', 'Nausea, diarrhea'),
    ('Omeprazole', 'Reduces stomach acid', '20mg daily', 'Headache, stomach pain'),
    ('Clopidogrel', 'Prevents blood clots', '75mg daily', 'Bleeding, rash'),
    ('Amoxicillin', 'Antibiotic for bacterial infections', '250mg every 8 hours', 'Diarrhea, allergic reactions'),
    ('Metoprolol', 'Beta-blocker for high blood pressure', '50mg daily', 'Fatigue, dizziness'),
    ('Ibuprofen', 'Anti-inflammatory for pain relief', '400mg every 8 hours', 'Stomach upset, rash'),
    ('Losartan', 'Blood pressure medication', '50mg daily', 'Dizziness, fatigue'),
    ('Atorvastatin', 'Lowers cholesterol', '10mg daily', 'Muscle pain, weakness'),
    ('Ciprofloxacin', 'Antibiotic for bacterial infections', '500mg every 12 hours', 'Nausea, diarrhea'),
    ('Omeprazole', 'Reduces stomach acid', '20mg daily', 'Headache, stomach pain'),
    ('Clopidogrel', 'Prevents blood clots', '75mg daily', 'Bleeding, rash');

INSERT INTO Rooms (roomNumber, type, capacity, occupiedBeds)
VALUES
    ('101', 'general', 4, 2),
    ('102', 'general', 4, 1),
    ('201', 'icu', 2, 2),
    ('202', 'icu', 2, 1),
    ('301', 'private', 1, 1),
    ('302', 'private', 1, 0),
    ('401', 'general', 4, 3),
    ('402', 'general', 4, 0),
    ('501', 'icu', 2, 0),
    ('502', 'private', 1, 0);

INSERT INTO Rooms (roomNumber, type, capacity, occupiedBeds)
VALUES
    ('303', 'private', 2, 1);

INSERT INTO Visit (hospitalizationSteps, prescription)
VALUES
    ('Admitted to ICU. Monitoring blood pressure and heart rate.', 'Beta-blockers prescribed'),
    ('Discharged with advice to rest and hydrate.', 'Paracetamol for fever'),
    ('Admitted to general ward. CT scan scheduled.', 'Painkillers prescribed'),
    ('Follow-up consultation. No hospitalization required.', 'No prescription needed');

INSERT INTO Doctors (userId, specialty, yearsOfExperience, availabilityStatus)
VALUES
    (1, 'Cardiology', 10, 'available'),
    (1, 'General Practice', 15, 'busy');

INSERT INTO Patients (name, surname, dateOfBirth, gender, phoneNumber, email, address, emergencyContactName, emergencyContactPhone, medicalHistory, status)
VALUES
    ('John', 'Doe', '1990-01-01', 'male', '555-1111', 'johndoe@example.com', '123 Main St', 'Jane Doe', '555-2222', 'No known allergies', 'queued'),
    ('Jane', 'Smith', '1985-05-10', 'female', '555-3333', 'janesmith@example.com', '456 Oak St', 'John Smith', '555-4444', 'Asthma', 'admitted'),
    ('Alice', 'Johnson', '1995-03-15', 'female', '555-5555', 'alicejohnson@example.com', '789 Pine St', 'Bob Johnson', '555-6666', 'Diabetes', 'released'),
    ('Bob', 'Brown', '1980-07-20', 'male', '555-7777', 'bobbrown@example.com', '321 Elm St', 'Alice Brown', '555-8888', 'Hypertension', 'admitted'),
    ('Chris', 'Evans', '1988-02-25', 'male', '555-9999', 'cevans@example.com', '567 Maple Ave', 'Steve Rogers', '555-1010', 'Heart surgery', 'admitted'),
    ('Diana', 'Prince', '1993-07-15', 'female', '555-2020', 'dprince@example.com', '789 Birch St', 'Bruce Wayne', '555-3030', 'Migraine', 'queued'),
    ('Bruce', 'Wayne', '1975-04-10', 'male', '555-4040', 'bwayne@example.com', '123 Gotham St', 'Alfred Pennyworth', '555-5050', 'Anemia', 'admitted'),
    ('Clark', 'Kent', '1985-06-18', 'male', '555-6060', 'ckent@example.com', '999 Metropolis St', 'Lois Lane', '555-7070', 'Dizziness', 'released'),
    ('Natasha', 'Romanoff', '1991-11-22', 'female', '555-8080', 'nromanoff@example.com', '333 Spy Lane', 'Nick Fury', '555-9090', 'PTSD', 'queued'),
    ('Steve', 'Rogers', '1920-07-04', 'male', '555-0000', 'srogers@example.com', '111 Shield St', 'Peggy Carter', '555-1111', 'Hypertension', 'released'),
    ('Jane', 'Smith', '1985-05-10', 'female', '555-3333', 'janesmith@example.com', '456 Oak St', 'John Smith', '555-4444', 'Asthma', 'admitted'),
    ('Alice', 'Johnson', '1995-03-15', 'female', '555-5555', 'alicejohnson@example.com', '789 Pine St', 'Bob Johnson', '555-6666', 'Diabetes', 'released'),
    ('Bob', 'Brown', '1980-07-20', 'male', '555-7777', 'bobbrown@example.com', '321 Elm St', 'Alice Brown', '555-8888', 'Hypertension', 'admitted'),
    ('Chris', 'Evans', '1988-02-25', 'male', '555-9999', 'cevans@example.com', '567 Maple Ave', 'Steve Rogers', '555-1010', 'Heart surgery', 'admitted'),
    ('Diana', 'Prince', '1993-07-15', 'female', '555-2020', 'dprince@example.com', '789 Birch St', 'Bruce Wayne', '555-3030', 'Migraine', 'queued'),
    ('Bruce', 'Wayne', '1975-04-10', 'male', '555-4040', 'bwayne@example.com', '123 Gotham St', 'Alfred Pennyworth', '555-5050', 'Anemia', 'admitted'),
    ('Clark', 'Kent', '1985-06-18', 'male', '555-6060', 'ckent@example.com', '999 Metropolis St', 'Lois Lane', '555-7070', 'Dizziness', 'released'),
    ('Natasha', 'Romanoff', '1991-11-22', 'female', '555-8080', 'nromanoff@example.com', '333 Spy Lane', 'Nick Fury', '555-9090', 'PTSD', 'queued'),
    ('Steve', 'Rogers', '1920-07-04', 'male', '555-0000', 'srogers@example.com', '111 Shield St', 'Peggy Carter', '555-1111', 'Hypertension', 'released'),
    ('Jane', 'Smith', '1985-05-10', 'female', '555-3333', 'janesmith@example.com', '456 Oak St', 'John Smith', '555-4444', 'Asthma', 'admitted'),
    ('Alice', 'Johnson', '1995-03-15', 'female', '555-5555', 'alicejohnson@example.com', '789 Pine St', 'Bob Johnson', '555-6666', 'Diabetes', 'released'),
    ('Bob', 'Brown', '1980-07-20', 'male', '555-7777', 'bobbrown@example.com', '321 Elm St', 'Alice Brown', '555-8888', 'Hypertension', 'admitted'),
    ('Chris', 'Evans', '1988-02-25', 'male', '555-9999', 'cevans@example.com', '567 Maple Ave', 'Steve Rogers', '555-1010', 'Heart surgery', 'admitted'),
    ('Diana', 'Prince', '1993-07-15', 'female', '555-2020', 'dprince@example.com', '789 Birch St', 'Bruce Wayne', '555-3030', 'Migraine', 'queued'),
    ('Bruce', 'Wayne', '1975-04-10', 'male', '555-4040', 'bwayne@example.com', '123 Gotham St', 'Alfred Pennyworth', '555-5050', 'Anemia', 'admitted'),
    ('Clark', 'Kent', '1985-06-18', 'male', '555-6060', 'ckent@example.com', '999 Metropolis St', 'Lois Lane', '555-7070', 'Dizziness', 'released'),
    ('Natasha', 'Romanoff', '1991-11-22', 'female', '555-8080', 'nromanoff@example.com', '333 Spy Lane', 'Nick Fury', '555-9090', 'PTSD', 'queued'),
    ('Steve', 'Rogers', '1920-07-04', 'male', '555-0000', 'srogers@example.com', '111 Shield St', 'Peggy Carter', '555-1111', 'Hypertension', 'released');

INSERT INTO Appointments (patientId, doctorId, appointmentDate, reasonForVisit, status)
VALUES
    (1, 1, '2025-01-10 10:00:00', 'Routine check-up', 'scheduled'),
    (2, 1, '2025-01-11 14:00:00', 'Consultation for fever', 'completed'),
    (3, 1, '2025-01-12 09:00:00', 'Headache and fatigue', 'scheduled'),
    (4, 1, '2025-01-13 16:00:00', 'Follow-up consultation', 'cancelled');

INSERT INTO Prescriptions (visitId, medicationId, quantity, dosageInstructions)
VALUES
    (1, 4, 30, 'Take 1 tablet daily in the morning'),
    (2, 1, 20, 'Take 1 tablet every 6 hours'),
    (3, 3, 15, 'Take 1 capsule every 8 hours'),
    (4, 2, 10, 'Take 1 tablet daily after meals');