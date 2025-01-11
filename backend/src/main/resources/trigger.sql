CREATE TRIGGER trg_update_priority_level
    BEFORE INSERT ON Queue
    FOR EACH ROW
BEGIN
    IF NEW.priorityPoints >= 80 THEN
        SET NEW.priorityLevel = 'high';
    ELSEIF NEW.priorityPoints >= 50 THEN
        SET NEW.priorityLevel = 'medium';
    ELSE
        SET NEW.priorityLevel = 'low';
    END IF;
END;

CREATE TRIGGER trg_complete_queue
    AFTER INSERT ON Visit
    FOR EACH ROW
BEGIN
    UPDATE Queue
    SET status = 'completed'
    WHERE id = NEW.id;
END;

CREATE TRIGGER trg_validate_occupied_beds
    BEFORE UPDATE ON Rooms
    FOR EACH ROW
BEGIN
    IF NEW.occupiedBeds > NEW.capacity THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Occupied beds cannot exceed room capacity';
    END IF;
END;

