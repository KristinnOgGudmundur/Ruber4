CREATE TABLE ru_reviews
(
  id int Identity (1, 1) primary key NOT NULL,
  userId int NOT NULL,
  driverId int NOT NULL,
  content nvarchar(500) NOT NULL,
  score int NOT NULL,

  foreign key(userId) references ru_users(id),
  foreign key(driverId) references ru_drivers(id)
)
