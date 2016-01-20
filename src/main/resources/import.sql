insert into drone(id, name, model, status, city) values (100, 'alpha', 'KPC124', 'Fonctionnel', 'Valence')
insert into drone(id, name, model, status, city) values (200, 'beta', 'KPC124', 'Fonctionnel', 'Roman')
insert into drone(id, name, model, status, city) values (300, 'gamma', 'KPC124', 'Fonctionnel', 'Montélimar')
insert into drone(id, name, model, status, city) values (400, 'omega', 'KPC124', 'Fonctionnel', 'Pierrelatte')

INSERT INTO SENSOR ( ID  , inservicedate, MODEL , NAME , PRICE, DRONE_ID  ) VALUES ( 200,'2016-01-01 00:00:00.0', 'OLKP986', 'Pressure Sensor', 45, 100)
INSERT INTO SENSOR ( ID  , inservicedate,MODEL , NAME , PRICE, DRONE_ID  ) VALUES ( 300,'2016-01-01 00:00:00.0', 'ZER435', 'Altimeter', 87, 200)
INSERT INTO SENSOR ( ID  , inservicedate,MODEL , NAME , PRICE, DRONE_ID  ) VALUES ( 400,'2016-01-01 00:00:00.0', 'UHI789', 'Light Sensor', 56, 300)
INSERT INTO SENSOR ( ID  , inservicedate,MODEL , NAME , PRICE, DRONE_ID  ) VALUES ( 500,'2016-01-01 00:00:00.0', 'NJK043', 'Temperature Sensor', 66, 400)


INSERT INTO analogic(id) VALUES (200)
INSERT INTO analogic(id) VALUES (300)
INSERT INTO analogic(id) VALUES (500)
INSERT INTO numeric(id) VALUES (400)
