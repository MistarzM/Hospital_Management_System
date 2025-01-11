EXPLAIN SELECT * FROM Triage WHERE name = 'John Doe' AND date = '2025-01-01';
EXPLAIN SELECT * FROM Queue WHERE status = 'pending' AND priorityLevel = 'high';
EXPLAIN SELECT * FROM Patients WHERE name = 'Chris' AND status = 'admitted';
EXPLAIN SELECT * FROM Medications WHERE name = 'Aspirin';
EXPLAIN SELECT * FROM Rooms WHERE type = 'ICU' AND occupiedBeds < capacity;

CALL AddPatient(
        'Bony',
        'Stark',
        '1970-05-29',
        'male',
        '555-1122',
        'tony.stark@example.com',
        '10880 Malibu Point',
        'Pepper Potts',
        '555-3344',
        'Iron deficiency'
     );

SELECT * FROM Patients WHERE name = 'Bony' AND surname = 'Stark';

CALL ScheduleAppointment(
        1, -- Patient ID
        1, -- Doctor ID
        '2025-02-18 10:00:00',
        'Routine follow-up again'
     );

SELECT * FROM Appointments WHERE patientId = 1 AND doctorId = 1;

SELECT
    Doctors.specialty AS DoctorSpecialty,
    Users.fullName AS DoctorName,
    Patients.name AS PatientName,
    Patients.surname AS PatientSurname,
    Appointments.appointmentDate AS AppointmentDate,
    Appointments.reasonForVisit AS ReasonForVisit
FROM
    Doctors
        INNER JOIN Users ON Doctors.userId = Users.id
        INNER JOIN Appointments ON Doctors.id = Appointments.doctorId
        INNER JOIN Patients ON Appointments.patientId = Patients.id
ORDER BY
    Appointments.appointmentDate;

SELECT
    DoctorName,
    DoctorSpecialty,
    PatientName,
    PatientSurname,
    AppointmentDate,
    ReasonForVisit
FROM
    PatientRoomVisitDoctor
WHERE
    AppointmentDate BETWEEN '2025-01-16' AND '2025-01-18'
ORDER BY
    AppointmentDate;



SELECT
    PatientName,
    PatientSurname,
    RoomNumber,
    RoomType,
    AppointmentDate,
    ReasonForVisit
FROM
    PatientRoomVisitDoctor
WHERE
    RoomNumber IS NOT NULL;

SELECT
    DoctorName,
    DoctorSpecialty,
    PatientName,
    PatientSurname,
    AppointmentDate,
    ReasonForVisit
FROM
    PatientRoomVisitDoctor
ORDER BY
    AppointmentDate;

INSERT INTO PatientRoomVisitDoctor (
    PatientName, PatientSurname, RoomNumber, RoomType, RoomTypeInt,
    AppointmentDate, ReasonForVisit, DoctorName, DoctorSpecialty
) VALUES
      ('John', 'Doe', '101', 'general', 1, '2025-01-15 10:00:00', 'Routine check-up', 'Dr. John Doe', 'Cardiology'),
      ('Jane', 'Smith', '201', 'icu', 2, '2025-01-16 11:00:00', 'Emergency visit', 'Dr. Chris Evans', 'ICU Specialist'),
      ('Alice', 'Johnson', '301', 'private', 3, '2025-01-17 09:30:00', 'Follow-up consultation', 'Dr. Bruce Wayne', 'General Medicine'),
      ('Bob', 'Brown', '202', 'icu', 2, '2025-01-18 14:00:00', 'Heart monitoring', 'Dr. Clark Kent', 'Cardiology');

SELECT
    PatientName, PatientSurname, RoomNumber, RoomType, AppointmentDate, ReasonForVisit
FROM
    PatientRoomVisitDoctor
WHERE
    RoomType = 'icu';