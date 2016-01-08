insert into company(id, name) values (1, 'sicap')
insert into company(id, name) values (2, 'atos')
insert into company(id, name) values (3, 'orange')
insert into user(id, email, company_id) VALUES (1, 'toto', 1)
insert into drone(id, model, name, city) values (1, 'Alpha', 'Toto', 'TOURNUS')
insert into flight(id, duration, drone_id) values (1, 300, 1)
insert into unit(id, unit) values (1, 'Celsius degrees') 
insert into sensor(id, name, model, drone_id) values (1, 'AlphaSensor', 'CoucouTournu', 1)
insert into analogic(id, unit) values (1, 1)
insert into suscription(id, sensor_id, user_id) values (1, 1, 1)
