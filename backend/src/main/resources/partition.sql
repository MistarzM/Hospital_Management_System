CREATE TABLE PatientRoomVisitDoctor (
                                        PatientName VARCHAR(100),
                                        PatientSurname VARCHAR(100),
                                        RoomNumber VARCHAR(10),
                                        RoomType ENUM('general', 'icu', 'private'),
                                        RoomTypeInt INT,
                                        AppointmentDate DATETIME,
                                        ReasonForVisit TEXT,
                                        DoctorName VARCHAR(100),
                                        DoctorSpecialty VARCHAR(100),
                                        KEY (RoomTypeInt)
)
    PARTITION BY LIST (RoomTypeInt) (
        PARTITION general_rooms VALUES IN (1), -- 'general'
        PARTITION icu_rooms VALUES IN (2),    -- 'icu'
        PARTITION private_rooms VALUES IN (3) -- 'private'
        );

