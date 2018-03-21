-- FileName:  kotlin-skeleton-db-query.sql
-- Date/TIme: 2018/03/21
-- Author Lim Kimhuor

CREATE DATABASE IF NOT EXISTS `kotlin_skeleton`;

CREATE USER 'kotlin_skeleton'@'127.0.0.1';
GRANT ALL PRIVILEGES ON `kotlin_skeleton`.* TO 'kotlin_skeleton'@'127.0.0.1' WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;
SET PASSWORD FOR 'kotlin_skeleton'@'127.0.0.1' = PASSWORD('kotlin_skeleton');

FLUSH PRIVILEGES;