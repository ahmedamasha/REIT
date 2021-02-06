
INSERT INTO status (color, name, created_at, updated_at)
VALUES ('#c7c4bb', 'In-progress', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO status (color, name, created_at, updated_at)
VALUES ('red', 'failed', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO status (color, name, created_at, updated_at)
VALUES ('#f0ad4e', 'pending', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO status (color, name, created_at, updated_at)
VALUES ('green', 'completed', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');


INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 1 ', 1, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 2 ', 2, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 3 ', 3, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 4 ', 1, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 5 ', 1, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');
INSERT INTO building (active, name, status_id, created_at, updated_at)
VALUES (true, 'building 6 ', 1, '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07');

INSERT INTO users (name)
VALUES ('Ahmed');
INSERT INTO users (name)
VALUES ('Ali');
INSERT INTO users (name)
VALUES ('Gasser');
INSERT INTO users (name)
VALUES ('Michel');
INSERT INTO users (name)
VALUES ('Sarah');
INSERT INTO users (name)
VALUES ('Hoda');



INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'painting , decor', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 1, 1, 1);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'trimming the garden', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 1, 2, 3);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'pest work', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 1, 3, 2);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'fixing , cleaning the windows', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 2, 1, 2);
INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'works in the roof', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 1, 3, 1);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'fixing electricity', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 3, 3, 2);
INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'renewing the fire extinguisher ', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 3, 3, 2);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'fixing some defects', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 4, 3, 2);

INSERT INTO activities (active, activity_name, created_at, updated_at, user_id, building_id, status_id)
VALUES (true, 'cleaning the facade', '2016-06-22 19:10:25-07', '2016-06-22 19:10:25-07', 5, 3, 2);
