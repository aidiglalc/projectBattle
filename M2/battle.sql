CREATE DATABASE battle_database;
USE battle_database;
-- FALTAN FKS

CREATE TABLE races (
race_id INTEGER PRIMARY KEY,
races VARCHAR(100)
);

CREATE TABLE weapons (
weapon_id INTEGER PRIMARY KEY,
weapon_name VARCHAR(25),
weapon_race VARCHAR(100),
weapon_image_path VARCHAR(100),
FOREIGN KEY (weapon_race)
REFERENCES races(race_id)
);

CREATE TABLE warriors (
warrior_id INTEGER PRIMARY KEY,
warrior_name VARCHAR(25),
warrior_race VARCHAR(25),
warrior_image_path VARCHAR(100),
FOREIGN KEY (warrior_race)
REFERENCES races(race_id)
);

CREATE TABLE players (
player_id INTEGER PRIMARY KEY,
player_name VARCHAR(25)
);

CREATE TABLE score (
game_id INTEGER PRIMARY KEY,
player_id INTEGER,
total_points INTEGER,
enemies_defeated INTEGER,
total_injuries_caused INTEGER,
total_injuries_suffered INTEGER,
FOREIGN KEY (player_id)
REFERENCES players(player_id)
);

CREATE TABLE battle (
battle_id INTEGER PRIMARY KEY,
game_id INTEGER,
player_id INTEGER,
warrior_id INTEGER,
warrior_weapon_id INTEGER,
opponent_id INTEGER,
opponent_weapon_id INTEGER,
injuries_caused INTEGER,
injuries_suffered INTEGER,
battle_points INTEGER,
FOREIGN KEY (game_id)
REFERENCES score(game_id),
FOREIGN KEY (player_id)
REFERENCES players(player_id),
FOREIGN KEY (warrior_id)
REFERENCES warriors(warrior_id),
FOREIGN KEY (warrior_weapon_id)
REFERENCES weapons(weapon_id),
FOREIGN KEY (opponent_id)
REFERENCES warriors(warrior_id),
FOREIGN KEY (opponent_weapon_id)
REFERENCES weapons(weapon_id)
);

