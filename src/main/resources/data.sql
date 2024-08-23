INSERT INTO utilisateur (username, password, email, role ) VALUES ('Customer', '$2a$10$Oi9wEGjoHMYauuhU6sDpZOZbAPIAIoDj/nbTO06PesrNziSihEU7y', 'customer@example.com', 0);
INSERT INTO utilisateur (username, password, email, role) VALUES ('Admin', '$2a$10$9mJH3BmqThNmR0.GUQyhne0MZQPtkKcYbp8M8QiuXzHJyGoqMcKI.', 'admin@example.com', 1);
INSERT INTO utilisateur (username, password, email, role) VALUES ('Patron', '$2a$10$OKmJUrocWJ3yLO3MAU4ds.c3WfJ7iBov/CD62x/X54b0.29tEJejO', 'patron@example.com', 2);
INSERT INTO utilisateur (username, password, email, role) VALUES ('Employe', '$2a$10$JKfjIPdGzTF9wrCKD/r42OQRoHl1osqCR5JuZh/hP/2p.8OEklSVi', 'employe@example.com', 3);

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


INSERT INTO restaurant (name, image_name) VALUES ('Burger Palace', 'burger.jpg');
INSERT INTO restaurant (name, image_name) VALUES ('Chez Glouton', 'glouton.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Urban Bites', 'urban-bites.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('La Patate qui Fume', 'patate.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('La Marmite Magique', 'marmite.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Le Palais Frétillant', 'palais.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Le Labo', 'labo.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Sushirama', 'sushirama.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Le Thai des Rues', 'thai.jfif');
INSERT INTO restaurant (name, image_name) VALUES ('Les Papilles', 'papilles.jfif');

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

INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (1, 1);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (1, 5);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (1, 8);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (3, 2);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (3, 10);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (4, 4);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (4, 1);
INSERT INTO utilisateur_restaurant (utilisateur_id, restaurant_id) VALUES (4, 8);
