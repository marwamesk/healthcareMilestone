CREATE TABLE doctor (
                        id VARCHAR(255) PRIMARY KEY,
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        specialty VARCHAR(255),
                        license_expiry_date DATE,
                        active BOOLEAN
);

INSERT INTO doctor (id, first_name, last_name, specialty, license_expiry_date, active) VALUES
                                                                                           ('11111111-1111-1111-1111-111111111111', 'Sarah', 'Chen', 'Cardiology', '2030-12-31', true),
                                                                                           ('22222222-2222-2222-2222-222222222222', 'Michael', 'Brown', 'Neurology', '2029-06-30', true),
                                                                                           ('33333333-3333-3333-3333-333333333333', 'Aisha', 'Khan', 'Dermatology', '2028-09-15', true),
                                                                                           ('44444444-4444-4444-4444-444444444444', 'James', 'Wilson', 'Orthopedics', '2031-01-10', true),
                                                                                           ('55555555-5555-5555-5555-555555555555', 'Emily', 'Davis', 'Pediatrics', '2027-11-20', true);

CREATE TABLE patient (
                         id VARCHAR(255) PRIMARY KEY,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         phone_number VARCHAR(255),
                         email VARCHAR(255),
                         date_of_birth DATE,
                         status VARCHAR(50),

                         country VARCHAR(255),
                         city VARCHAR(255),
                         postal_code VARCHAR(255),
                         street_name VARCHAR(255),
                         street_number INTEGER,

                         health_card_num VARCHAR(255),
                         expiry_date DATE
);

INSERT INTO patient VALUES
                        ('p1','John','Doe','123','john@mail.com','2000-01-01','ACTIVE','CA','Montreal','H1A1A1','Main',10,'DOES90101516','2027-01-01'),
                        ('p2','Anna','Smith','124','anna@mail.com','1998-02-02','ACTIVE','CA','Toronto','H2B2B2','King',20,'SMIT89761235','2029-01-01'),
                        ('p3','Mike','Brown','125','mike@mail.com','1995-03-03','ACTIVE','CA','Vancouver','H3C3C3','West',30,'BROW33329867','2026-06-01'),
                        ('p4','Sara','Lee','126','sara@mail.com','1997-04-04','INACTIVE','CA','Ottawa','H4D4D4','East',40,'LEEM44569187','2028-12-01'),
                        ('p5','Tom','White','127','tom@mail.com','1999-05-05','ACTIVE','CA','Quebec','H5E5E5','North',50,'WHIT55680198','2027-03-01');

UPDATE patient
SET status = 'STABLE'
WHERE status = 'ACTIVE';

UPDATE patient
SET status = 'STABLE'
WHERE status = 'INACTIVE';

UPDATE patient
SET status = 'CRITICAL'
WHERE id = 'p2';

CREATE TABLE appointment (
                             id VARCHAR(255) PRIMARY KEY,
                             doctor_id VARCHAR(255) NOT NULL,
                             patient_id VARCHAR(255) NOT NULL,
                             time TIMESTAMP NOT NULL,
                             status VARCHAR(50),

                             FOREIGN KEY (doctor_id) REFERENCES doctor(id),
                             FOREIGN KEY (patient_id) REFERENCES patient(id)
);

INSERT INTO appointment VALUES
                            ('a1','11111111-1111-1111-1111-111111111111','p1','2026-04-10 10:00:00','SCHEDULED'),
                            ('a2','22222222-2222-2222-2222-222222222222','p2','2026-04-11 11:00:00','SCHEDULED'),
                            ('a3','33333333-3333-3333-3333-333333333333','p3','2026-04-12 09:30:00','COMPLETED'),
                            ('a4','44444444-4444-4444-4444-444444444444','p4','2026-04-13 14:00:00','CANCELLED'),
                            ('a5','55555555-5555-5555-5555-555555555555','p5','2026-04-14 16:00:00','SCHEDULED');

CREATE TABLE billing (
                         id VARCHAR(255) PRIMARY KEY,
                         patient_id VARCHAR(255) NOT NULL,
                         appointment_id VARCHAR(255),
                         amount DOUBLE,
                         description VARCHAR(255),

                         FOREIGN KEY (patient_id) REFERENCES patient(id),
                         FOREIGN KEY (appointment_id) REFERENCES appointment(id)
);

INSERT INTO billing VALUES
                        ('b1','p1','a1',120.5,'Consultation'),
                        ('b2','p2','a2',200.0,'Cardio check'),
                        ('b3','p3','a3',180.0,'Neuro exam'),
                        ('b4','p4','a4',120.0,'Consultation'),
                        ('b5','p5','a5',150.0,'General checkup');

ALTER TABLE billing ADD due_date DATE;
ALTER TABLE billing ADD payment_method VARCHAR(50);
ALTER TABLE billing ADD status VARCHAR(50);

UPDATE billing SET due_date = '2026-04-20', payment_method = 'CASH', status = 'PENDING' WHERE id = 'b1';
UPDATE billing SET due_date = '2026-04-21', payment_method = 'CREDIT_CARD', status = 'PAID' WHERE id = 'b2';
UPDATE billing SET due_date = '2026-04-22', payment_method = 'INSURANCE', status = 'PENDING' WHERE id = 'b3';
UPDATE billing SET due_date = '2026-04-23', payment_method = 'CASH', status = 'PENDING' WHERE id = 'b4';
UPDATE billing SET due_date = '2026-04-24', payment_method = 'CREDIT_CARD', status = 'PENDING' WHERE id = 'b5';


ALTER TABLE billing DROP COLUMN patient_id;
ALTER TABLE billing DROP COLUMN appointment_id;
ALTER TABLE appointment ADD billing_id VARCHAR(255);
ALTER TABLE appointment
    ADD CONSTRAINT fk_appointment_billing
        FOREIGN KEY (billing_id) REFERENCES billing(id);
UPDATE appointment SET billing_id = 'b1' WHERE id = 'a1';
UPDATE appointment SET billing_id = 'b2' WHERE id = 'a2';
UPDATE appointment SET billing_id = 'b3' WHERE id = 'a3';
UPDATE appointment SET billing_id = 'b4' WHERE id = 'a4';
UPDATE appointment SET billing_id = 'b5' WHERE id = 'a5';