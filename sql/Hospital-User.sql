CREATE USER IF NOT EXISTS 'hospital_user'@'%' IDENTIFIED BY 'hospital_user_password';

GRANT SELECT ON hospital.* TO 'hospital_user'@'%';

FLUSH PRIVILEGES;