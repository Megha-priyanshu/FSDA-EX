-- Create schema
CREATE DATABASE IF NOT EXISTS inventory_db_2400031798;
USE inventory_db_2400031798;

-- Student/Admin table
CREATE TABLE IF NOT EXISTS admin_info (
    student_id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Insert your details
INSERT INTO admin_info (student_id, name)
VALUES (2400031798, 'Manoj');
