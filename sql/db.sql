create database if not exists LIBRARY;
create user if not exists 'library_admin'@'localhost' identified by 'library_admin123';
grant all privileges on LIBRARY.* TO 'library_admin'@'localhost';
flush privileges;