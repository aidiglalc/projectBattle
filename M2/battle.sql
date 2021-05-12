DROP DATABASE battle_database;
CREATE DATABASE battle_database;
USE battle_database;

CREATE TABLE weapons (
weapon_id INTEGER AUTO_INCREMENT PRIMARY KEY,
weapon_name VARCHAR(25),
weapon_strength INTEGER,
weapon_speed INTEGER,
weapon_race VARCHAR(50),
weapon_image_path VARCHAR(100),
weapon_points INTEGER
);

CREATE TABLE race (
race_id INTEGER AUTO_INCREMENT PRIMARY KEY,
race VARCHAR(100),
hp INTEGER,
strength INTEGER,
defense INTEGER,
agility INTEGER,
speed INTEGER,
race_points INTEGER
);

CREATE TABLE warriors (
warrior_id INTEGER AUTO_INCREMENT PRIMARY KEY,
warrior_name VARCHAR(25),
warrior_race INTEGER,
warrior_image_path VARCHAR(100),
FOREIGN KEY (warrior_race) REFERENCES race(race_id)
);

CREATE TABLE players (
player_id INTEGER AUTO_INCREMENT PRIMARY KEY,
player_name VARCHAR(25)
);

CREATE TABLE game (
game_id INTEGER AUTO_INCREMENT PRIMARY KEY,
player_id INTEGER,
player_name VARCHAR(25),
warrior_id INTEGER,
warrior_weapon_id INTEGER,
total_points INTEGER,
enemies_defeated INTEGER,
total_injuries_caused INTEGER,
total_injuries_suffered INTEGER,
FOREIGN KEY (player_id) REFERENCES players(player_id),
FOREIGN KEY (warrior_id) REFERENCES warriors(warrior_id),
FOREIGN KEY (warrior_weapon_id) REFERENCES weapons(weapon_id)
);

CREATE TABLE battle (
battle_id INTEGER AUTO_INCREMENT PRIMARY KEY,
game_id INTEGER,
player_id INTEGER,
warrior_id INTEGER,
warrior_weapon_id INTEGER,
opponent_id INTEGER,
opponent_weapon_id INTEGER,
injuries_caused INTEGER,
injuries_suffered INTEGER,
battle_points INTEGER,
FOREIGN KEY (game_id) REFERENCES game(game_id),
FOREIGN KEY (player_id) REFERENCES players(player_id),
FOREIGN KEY (warrior_id) REFERENCES warriors(warrior_id),
FOREIGN KEY (warrior_weapon_id) REFERENCES weapons(weapon_id),
FOREIGN KEY (opponent_id) REFERENCES warriors(warrior_id),
FOREIGN KEY (opponent_weapon_id) REFERENCES weapons(weapon_id)
);

INSERT INTO weapons(weapon_name, weapon_strength, weapon_speed, weapon_race, weapon_image_path, weapon_points) 
VALUES ("Dagger", 0, 3, "Human, Elf", null, 10),
("Sword", 1, 1, "Human, Elf, Dwarf", null, 10),
("Axe", 3, 0, "Human, Dwarf", null, 10),
("Double Swords", 2, 2, "Human, Elf", null, 14),
("Scimitar", 1, 2, "Human, Elf", null, 14),
("Bow", 1, 5, "Elf", null, 15),
("Katana", 2, 3, "Human", null, 18),
("Dirk", 0, 4, "Human, Elf, Dwarf", null, 12),
("Two-handed Axe", 5, 0, "Dwarf", null, 20);

INSERT INTO race(race, hp, strength, defense, agility, speed, race_points)
VALUES ("Human", 50, 5, 3, 6, 5, 20),
("Elf", 40, 4, 2, 7, 7, 19),
("Dwarf", 60, 6, 4, 5, 3, 21);

INSERT INTO warriors(warrior_name, warrior_race, warrior_image_path)
VALUES ("Erdrick", 1, "Human_1.jpg"),
("Firion", 1, "Human_2.jpg"),
("Valindra", 2, "Elf_1.jpg"),
("Taegen", 2, "Elf_2.jpg"),
("Saphielle", 2, "Elf_3.jpg"),
("Mukhir", 3, "Dwarf_1.jpg"),
("Thalgreak", 3, "Dwarf_2.jpg"),
("Gathul", 3, "Dwarf_3.jpg");