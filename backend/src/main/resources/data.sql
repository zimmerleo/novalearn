INSERT INTO chemistry_aggregatestates (id, name) VALUES (1, 'Solid');
INSERT INTO chemistry_aggregatestates (id, name) VALUES (2, 'Liquid');
INSERT INTO chemistry_aggregatestates (id, name) VALUES (3, 'Gaseous');

INSERT INTO chemistry_appearances (id, name) VALUES (1, 'Natural');
INSERT INTO chemistry_appearances (id, name) VALUES (2, 'Natural and radioactive');
INSERT INTO chemistry_appearances (id, name) VALUES (3, 'Synthetic');

INSERT INTO chemistry_groups (id, name, main_group) VALUES (1, 'Alkali metals', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (2, 'Alkaline-earth metals', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (3, 'Triels', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (4, 'Tetrels', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (5, 'Pnictogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (6, 'Chalogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (7, 'Halogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (8, 'Noble gases', true);

INSERT INTO chemistry_groups (id, name, main_group) VALUES (10, 'Scandium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (11, 'Titanium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (12, 'Vanadium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (13, 'Chromium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (14, 'Manganese group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (15, 'Iron group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (16, 'Cobalt group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (17, 'Nickel group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (18, 'Copper group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (19, 'Zinc group', false);

INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (1, 1.0079, 'Hydrogen', 'H', 3, 1, 1, 1);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (2, 4.0026, 'Helium', 'He', 3, 1, 8, 1);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (3, 6.941, 'Lithium', 'Li', 3, 1, 1, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (4, 9.0122, 'Beryllium', 'Be', 3, 1, 2, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (5, 10.811, 'Boron', 'B', 3, 1, 3, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (6, 12.0107, 'Carbon', 'C', 3, 1, 4, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (7, 14.0067, 'Nitrogen', 'N', 3, 1, 5, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (8, 15.9994, 'Oxygen', 'O', 3, 1, 6, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (9, 18.9984, 'Fluorine', 'F', 3, 1, 7, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (10, 20.1797, 'Neon', 'Ne', 3, 1, 8, 2);