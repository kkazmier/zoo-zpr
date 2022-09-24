insert into zones (id, name) values (1, 'strefa sloni');
insert into zones (id, name) values (2, 'strefa krolikow');
insert into zones (id, name) values (3, 'strefa lwow');
insert into zones (id, name) values (4, 'strefa koedukacyjna');

insert into animal_types (id, name, type) values (11, 'krolik', 'ssak');
insert into animal_types (id, name, type) values (12, 'lew', 'ssak');
insert into animal_types (id, name, type) values (13, 'slon', 'ssak');

insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (21, 'Robert', 20, 1, 13);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (22, 'Czarek', 20, 1, 13);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (23, 'Kacper', 4, 2, 11);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (24, 'Romek', 4, 2, 11);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (25, 'Leonardo', 11, 3, 12);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (26, 'Leszek', 11, 3, 12);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (27, 'Kamil', 4, 4, 11);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (28, 'Leon', 11, 4, 12);
insert into animals (id, name, feed_quantity, zone_id, animal_type_id) values (29, 'Tytus', 20, 4, 13);
