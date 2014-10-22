CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  name nvarchar(256) NOT NULL,
  car nvarchar(128) NOT NULL
)