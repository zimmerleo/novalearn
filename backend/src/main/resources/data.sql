INSERT INTO chemistry_aggregatestates (id, name) VALUES (1, 'Solid');
INSERT INTO chemistry_aggregatestates (id, name) VALUES (2, 'Liquid');
INSERT INTO chemistry_aggregatestates (id, name) VALUES (3, 'Gaseous');

INSERT INTO chemistry_appearances (id, name) VALUES (1, 'Natural');
INSERT INTO chemistry_appearances (id, name) VALUES (2, 'Natural and radioactive');
INSERT INTO chemistry_appearances (id, name) VALUES (3, 'Synthetic');

INSERT INTO chemistry_groups (id, name, main_group) VALUES (1, 'Alkali metals', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (2, 'Alkaline-earth metals', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (3, 'Scandium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (4, 'Titanium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (5, 'Vanadium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (6, 'Chromium group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (7, 'Manganese group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (8, 'Iron group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (9, 'Cobalt group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (10, 'Nickel group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (11, 'Copper group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (12, 'Zinc group', false);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (13, 'Triels', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (14, 'Tetrels', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (15, 'Pnictogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (16, 'Chalogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (17, 'Halogens', true);
INSERT INTO chemistry_groups (id, name, main_group) VALUES (18, 'Noble gases', true);

INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (1, 1.0079, 'Hydrogen', 'H', 3, 1, 1, 1);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (2, 4.0026, 'Helium', 'He', 3, 1, 18, 1);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (3, 6.941, 'Lithium', 'Li', 1, 1, 1, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (4, 9.0122, 'Beryllium', 'Be', 1, 1, 2, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (5, 10.811, 'Boron', 'B', 1, 1, 13, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (6, 12.0107, 'Carbon', 'C', 1, 1, 14, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (7, 14.0067, 'Nitrogen', 'N', 3, 1, 15, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (8, 15.9994, 'Oxygen', 'O', 3, 1, 16, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (9, 18.9984, 'Fluorine', 'F', 3, 1, 17, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (10, 20.1797, 'Neon', 'Ne', 3, 1, 18, 2);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (11, 22.990, 'Sodium', 'Na', 1, 1, 1, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (12, 24.305, 'Magnesium', 'Mg', 1, 1, 2, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (13, 26.982, 'Aluminium', 'Al', 1, 1, 13, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (14, 28.085, 'Silicon', 'Si', 1, 1, 14, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (15, 30.974, 'Phosphorus', 'P', 1, 1, 15, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (16, 32.06, 'Sulfur', 'S', 1, 1, 16, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (17, 35.45, 'Chlorine', 'Cl', 3, 1, 17, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (18, 39.948, 'Argon', 'Ar', 3, 1, 18, 3);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (19, 39.098, 'Potassium', 'K', 1, 1, 1, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (20, 40.078, 'Calcium', 'Ca', 1, 1, 2, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (21, 44.956, 'Scandium', 'Sc', 1, 1, 3, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (22, 47.867, 'Titanium', 'Ti', 1, 1, 4, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (23, 50.942, 'Vanadium', 'V', 1, 1, 5, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (24, 51.996, 'Chromium', 'Cr', 1, 1, 6, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (25, 54.938, 'Manganese', 'Mn', 1, 1, 7, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (26, 55.845, 'Iron', 'Fe', 1, 1, 8, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (27, 58.933, 'Cobalt', 'Co', 1, 1, 9, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (28, 58.693, 'Nickel', 'Ni', 1, 1, 10, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (29, 63.546, 'Copper', 'Cu', 1, 1, 11, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (30, 65.38, 'Zinc', 'Zn', 1, 1, 12, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (31, 69.723, 'Gallium', 'Ga', 1, 1, 13, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (32, 72.630, 'Germanium', 'Ge', 1, 1, 14, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (33, 74.922, 'Arsenic', 'As', 1, 1, 15, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (34, 78.971, 'Selenium', 'Se', 1, 1, 16, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (35, 79.904, 'Bromine', 'Br', 2, 1, 17, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (36, 83.798, 'Krypton', 'Kr', 3, 1, 18, 4);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (37, 85.468, 'Rubidium', 'Rb', 1, 1, 1, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (38, 87.62, 'Strontium', 'Sr', 1, 1, 2, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (39, 88.906, 'Yttrium', 'Y', 1, 1, 3, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (40, 91.224, 'Zirconium', 'Zr', 1, 1, 4, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (41, 92.906, 'Niobium', 'Nb', 1, 1, 5, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (42, 95.95, 'Molybdenum', 'Mo', 1, 1, 6, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (43, 98.0, 'Technetium', 'Tc', 1, 2, 7, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (44, 101.07, 'Ruthenium', 'Ru', 1, 1, 8, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (45, 102.91, 'Rhodium', 'Rh', 1, 1, 9, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (46, 106.42, 'Palladium', 'Pd', 1, 1, 10, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (47, 107.87, 'Silver', 'Ag', 1, 1, 11, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (48, 112.41, 'Cadmium', 'Cd', 1, 1, 12, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (49, 114.82, 'Indium', 'In', 1, 1, 13, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (50, 118.71, 'Tin', 'Sn', 1, 1, 14, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (51, 121.76, 'Antimony', 'Sb', 1, 1, 15, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (52, 127.60, 'Tellurium', 'Te', 1, 1, 16, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (53, 126.90, 'Iodine', 'I', 1, 1, 17, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (54, 131.29, 'Xenon', 'Xe', 3, 1, 18, 5);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (55, 132.91, 'Cesium', 'Cs', 1, 1, 1, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (56, 137.33, 'Barium', 'Ba', 1, 1, 2, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (57, 138.91, 'Lanthanum', 'La', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (58, 140.12, 'Cerium', 'Ce', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (59, 140.91, 'Praseodymium', 'Pr', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (60, 144.24, 'Neodymium', 'Nd', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (61, 144.9, 'Promethium', 'Pm', 1, 3, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (62, 150.36, 'Samarium', 'Sm', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (63, 151.96, 'Europium', 'Eu', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (64, 157.25, 'Gadolinium', 'Gd', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (65, 158.93, 'Terbium', 'Tb', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (66, 162.50, 'Dysprosium', 'Dy', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (67, 164.93, 'Holmium', 'Ho', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (68, 167.26, 'Erbium', 'Er', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (69, 168.93, 'Thulium', 'Tm', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (70, 173.05, 'Ytterbium', 'Yb', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (71, 174.97, 'Lutetium', 'Lu', 1, 1, 3, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (72, 178.49, 'Hafnium', 'Hf', 1, 1, 4, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (73, 180.95, 'Tantalum', 'Ta', 1, 1, 5, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (74, 183.84, 'Tungsten', 'W', 1, 1, 6, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (75, 186.21, 'Rhenium', 'Re', 1, 1, 7, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (76, 190.23, 'Osmium', 'Os', 1, 1, 8, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (77, 192.22, 'Iridium', 'Ir', 1, 1, 9, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (78, 195.08, 'Platinum', 'Pt', 1, 1, 10, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (79, 196.97, 'Gold', 'Au', 1, 1, 11, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (80, 200.59, 'Mercury', 'Hg', 2, 1, 12, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (81, 204.38, 'Thallium', 'Tl', 1, 1, 13, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (82, 207.2, 'Lead', 'Pb', 1, 1, 14, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (83, 208.98, 'Bismuth', 'Bi', 1, 1, 15, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (84, 208.9, 'Polonium', 'Po', 1, 2, 16, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (85, 209.9, 'Astatine', 'At', 1, 2, 17, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (86, 222.0, 'Radon', 'Rn', 3, 2, 18, 6);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (87, 223.0, 'Francium', 'Fr', 1, 2, 1, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (88, 226.0, 'Radium', 'Ra', 1, 2, 2, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (89, 227.0, 'Actinium', 'Ac', 1, 2, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (90, 232.04, 'Thorium', 'Th', 1, 1, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (91, 231.04, 'Protactinium', 'Pa', 1, 2, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (92, 238.03, 'Uranium', 'U', 1, 1, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (93, 237.0, 'Neptunium', 'Np', 1, 2, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (94, 244.0, 'Plutonium', 'Pu', 1, 1, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (95, 243.0, 'Americium', 'Am', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (96, 247.0, 'Curium', 'Cm', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (97, 247.0, 'Berkelium', 'Bk', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (98, 251.0, 'Californium', 'Cf', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (99, 252.0, 'Einsteinium', 'Es', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (100, 257.0, 'Fermium', 'Fm', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (101, 258.0, 'Mendelevium', 'Md', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (102, 259.1, 'Nobelium', 'No', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (103, 262.1, 'Lawrencium', 'Lr', 1, 3, 3, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (104, 267.1, 'Rutherfordium', 'Rf', 1, 3, 4, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (105, 268.1, 'Dubnium', 'Db', 1, 3, 5, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (106, 271.1, 'Seaborgium', 'Sg', 1, 3, 6, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (107, 272.1, 'Bohrium', 'Bh', 1, 3, 7, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (108, 270.1, 'Hassium', 'Hs', 1, 3, 8, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (109, 276.1, 'Meitnerium', 'Mt', 1, 3, 9, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (110, 281.1, 'Darmstadtium', 'Ds', 1, 3, 10, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (111, 282.1, 'Roentgenium', 'Rg', 1, 3, 11, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (112, 285.17, 'Copernicium', 'Cn', 2, 3, 12, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (113, 286.18, 'Nihonium', 'Nh', 1, 3, 13, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (114, 289.19, 'Flerovium', 'Fl', 1, 3, 14, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (115, 290.19, 'Moscovium', 'Mc', 1, 3, 15, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (116, 293.20, 'Livermorium', 'Lv', 1, 3, 16, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (117, 294.20, 'Tennessine', 'Ts', 1, 3, 17, 7);
INSERT INTO chemistry_atoms (id, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (118, 294.0, 'Oganesson', 'Og', 3, 3, 18, 7);