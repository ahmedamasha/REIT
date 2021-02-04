INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 1 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 2 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 3 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 4 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 5 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO building (active,  name, created_at, updated_at) VALUES (true ,'building 6 ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');


INSERT INTO status (color,  name, created_at, updated_at) VALUES ('green' ,'on-progress' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO status (color,  name, created_at, updated_at) VALUES ('red' ,'failed' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');
INSERT INTO status (color,  name, created_at, updated_at) VALUES ('#ccc' ,'pending' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07');


INSERT INTO users ( name  ) VALUES ('Ahmed');
INSERT INTO users ( name  ) VALUES ('Ali');
INSERT INTO users ( name  ) VALUES ('Gasser');



INSERT INTO activities (active,  activity_name, created_at, updated_at , assigned_to,building_id,status_id) VALUES (true ,'fixing AC' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07', 1 ,1 ,1);
INSERT INTO activities (active,  activity_name, created_at, updated_at , assigned_to,building_id,status_id) VALUES (true ,'fixing , cleaning the windowes' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07', 2 ,1 ,2);
INSERT INTO activities (active,  activity_name, created_at, updated_at , assigned_to,building_id,status_id) VALUES (true ,' works in the roof ' ,'2016-06-22 19:10:25-07','2016-06-22 19:10:25-07', 1 ,3 ,1);
