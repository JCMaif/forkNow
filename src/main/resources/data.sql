INSERT INTO utilisateur (username, password, email, role ) VALUES ('Customer', '$2a$10$Oi9wEGjoHMYauuhU6sDpZOZbAPIAIoDj/nbTO06PesrNziSihEU7y', 'customer@example.com', 0);
INSERT INTO utilisateur (username, password, email, role) VALUES ('Admin', '$2a$10$9mJH3BmqThNmR0.GUQyhne0MZQPtkKcYbp8M8QiuXzHJyGoqMcKI.', 'admin@example.com', 1);

INSERT INTO cuisine (type) VALUES ('Burger');
INSERT INTO cuisine (type) VALUES ('Française');
INSERT INTO cuisine (type) VALUES ('Street');
INSERT INTO cuisine (type) VALUES ('Terroir');
INSERT INTO cuisine (type) VALUES ('Traditionnelle');
INSERT INTO cuisine (type) VALUES ('Gastronomique');
INSERT INTO cuisine (type) VALUES ('Moléculaire');
INSERT INTO cuisine (type) VALUES ('Moléculaire');
INSERT INTO cuisine (type) VALUES ('Japonaise');
INSERT INTO cuisine (type) VALUES ('Thai');


INSERT INTO restaurant (name) VALUES ('Burger Palace');
INSERT INTO restaurant (name) VALUES ('Chez Glouton');
INSERT INTO restaurant (name) VALUES ('Street Gourmand');
INSERT INTO restaurant (name) VALUES ('Le Terroir Enchanté');
INSERT INTO restaurant (name) VALUES ('La Marmite Magique');
INSERT INTO restaurant (name) VALUES ('Le Palais Frétillant');
INSERT INTO restaurant (name) VALUES ('Le Fumet Du Diable');
INSERT INTO restaurant (name) VALUES ('Sushirama');
INSERT INTO restaurant (name) VALUES ('Le Thai des Rues');
INSERT INTO restaurant (name) VALUES ('Les Papilles Enflammées');

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (1, 1);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (2, 2);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (2, 5);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (3, 3);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (3, 1);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (4, 4);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (4, 5);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (5, 2);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (5, 6);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (6, 6);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (6, 7);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (7, 7);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (8, 8);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (9, 9);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (9, 3);

INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (10, 2);
INSERT INTO restaurant_cuisine (restaurant_id, cuisine_id) VALUES (10, 4);
