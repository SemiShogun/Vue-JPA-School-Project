INSERT INTO Continent(id, continentName) values (1, 'Europe');
INSERT INTO Continent(id, continentName) values (2, 'North America');

INSERT INTO Country(id, countryName, continent_id) values (1, 'Switzerland', 1);
INSERT INTO Country(id, countryName, continent_id) values (2, 'USA', 2);
INSERT INTO Country(id, countryName, continent_id) values (3, 'Canada', 2);

INSERT INTO Infected(id, name, surName, age, country_id) values (1, 'Maxi', 'Mustermann', 18, 1);
INSERT INTO Infected(id, name, surName, age, country_id) values (2, 'Boxi', 'What', 18, 2);
INSERT INTO Infected(id, name, surName, age, country_id) values (3, 'Roxi', 'Lol', 18, 2);

