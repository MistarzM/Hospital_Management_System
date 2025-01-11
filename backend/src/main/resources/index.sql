CREATE INDEX idx_triage_name_date ON Triage(name, date);
CREATE INDEX idx_queue_status_priority ON Queue(status, priorityLevel);
CREATE INDEX idx_patients_name_status ON Patients(name, status);
CREATE INDEX idx_medications_name ON Medications(name);