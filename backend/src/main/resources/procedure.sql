DELIMITER //
CREATE PROCEDURE AddPatient(
    IN p_name VARCHAR(100),
    IN p_surname VARCHAR(100),
    IN p_dateOfBirth DATE,
    IN p_gender ENUM('male', 'female', 'other'),
    IN p_phoneNumber VARCHAR(20),
    IN p_email VARCHAR(100),
    IN p_address TEXT,
    IN p_emergencyContactName VARCHAR(100),
    IN p_emergencyContactPhone VARCHAR(20),
    IN p_medicalHistory TEXT
)
BEGIN
    IF p_name IS NULL OR p_surname IS NULL THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Name and Surname cannot be null';
    END IF;

    INSERT INTO Patients (
        name, surname, dateOfBirth, gender, phoneNumber, email, address,
        emergencyContactName, emergencyContactPhone, medicalHistory
    )
    VALUES (
               p_name, p_surname, p_dateOfBirth, p_gender, p_phoneNumber, p_email,
               p_address, p_emergencyContactName, p_emergencyContactPhone, p_medicalHistory
           );
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE ScheduleAppointment(
    IN p_patientId INT,
    IN p_doctorId INT,
    IN p_appointmentDate DATETIME,
    IN p_reasonForVisit TEXT
)
BEGIN
    IF p_patientId IS NULL OR p_doctorId IS NULL THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Patient ID and Doctor ID cannot be null';
    END IF;

    INSERT INTO Appointments (
        patientId, doctorId, appointmentDate, reasonForVisit, status
    )
    VALUES (
               p_patientId, p_doctorId, p_appointmentDate, p_reasonForVisit, 'scheduled'
           );
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE AssignRoom(
    IN p_roomId INT,
    IN p_patientId INT
)
BEGIN
    UPDATE Rooms
    SET occupiedBeds = occupiedBeds + 1
    WHERE id = p_roomId AND occupiedBeds < capacity;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Room is full or does not exist';
    END IF;

    UPDATE Patients
    SET status = 'admitted'
    WHERE id = p_patientId;
END //
DELIMITER ;

CREATE TRIGGER trg_prevent_user_deletion
    BEFORE DELETE ON Users
    FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM Doctors WHERE userId = OLD.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot delete user with assigned doctor role';
    END IF;
END;

SELECT * FROM Patients WHERE name = 'Tony';