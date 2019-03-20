CREATE DATABASE employee_dev;
CREATE DATABASE  employee_prod;

CREATE USER 'employee_dev_user'@'localhost' IDENTIFIED  by 'pass';
CREATE USER 'employee_prod_user'@'localhost' IDENTIFIED  by 'pass';


GRANT SELECT ON employee_dev.* to 'employee_dev_user'@'localhost';
GRANT INSERT ON employee_dev.* to 'employee_dev_user'@'localhost';
GRANT DELETE ON employee_dev.* to 'employee_dev_user'@'localhost';
GRANT UPDATE ON employee_dev.* to 'employee_dev_user'@'localhost';


GRANT SELECT ON employee_dev.* to 'employee_prod_user'@'localhost';
GRANT INSERT ON employee_dev.* to 'employee_prod_user'@'localhost';
GRANT DELETE ON employee_dev.* to 'employee_prod_user'@'localhost';
GRANT UPDATE ON employee_dev.* to 'employee_prod_user'@'localhost';
