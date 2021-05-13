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
warrior_lore VARCHAR(100),
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
VALUES ("Dagger", 0, 3, "Human, Elf", "dagger.jpg", 10),
("Sword", 1, 1, "Human, Elf, Dwarf", "sword.jpg", 10),
("Axe", 3, 0, "Human, Dwarf", "axe.jpg", 10),
("Double Swords", 2, 2, "Human, Elf", "double_swords.jpg", 14),
("Scimitar", 1, 2, "Human, Elf", "scimitar.jpg", 14),
("Bow", 1, 5, "Elf", "bow.jpg", 15),
("Katana", 2, 3, "Human", "katana.jpg", 18),
("Dirk", 0, 4, "Human, Elf, Dwarf", "dirk.jpg", 12),
("Two-handed Axe", 5, 0, "Dwarf", "two-handed_axe.jpg", 20);

INSERT INTO race(race, hp, strength, defense, agility, speed, race_points)
VALUES ("Human", 50, 5, 3, 6, 5, 20),
("Elf", 40, 4, 2, 7, 7, 19),
("Dwarf", 60, 6, 4, 5, 3, 21);

INSERT INTO warriors(warrior_name, warrior_race, warrior_image_path, warrior_lore)
VALUES ("Erdrick", 1, "Human_1.JPG", "<html>When he turned 18, he embarked to finish the quest that his father began.</html>"),
("Firion", 1, "Human_2.JPG", "<html>Losing his brother in war, he joined the militia to avenge him.</html>"),
("Valindra", 2, "Elf_1.JPG", "<html>She embarked on an adventure to reclaim the eye of the sun.</html>"),
("Taegen", 2, "Elf_2.JPG", "<html>Cursed by a Demon he seeks the cure to see the sun again.</html>"),
("Elanor", 2, "Elf_3.JPG", "<html>She left the elven city Avalon to see the beauty of the outside world.</html>"),
("Mukhir", 3, "Dwarf_1.JPG", "<html>Tired of the life of the mine, he wants to live a life full of adventures.</html>"),
("Thalkrum", 3, "Dwarf_2.JPG", "<html>He is dedicated to giving his services as a bodyguard, for a price.</html>"),
("Garzhulg", 3, "Dwarf_3.JPG", "<html>He is searching for the legendary pickaxe that can mine orichalcum.</html>");