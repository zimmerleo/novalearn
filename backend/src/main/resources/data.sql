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

INSERT INTO chemistry_atoms (atomic_number, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (1, 1.0079, 'Hydrogen', 'H', 3, 1, 1, 1);
INSERT INTO chemistry_atoms (atomic_number, atomic_mass, name, symbol, aggregate_state_id, appearance_id, group_id, period)
VALUES (8, 15.999, 'Oxygen', 'O', 3, 1, 6, 2);

INSERT INTO chemistry_molecules (id, molecular_mass, chemical_formula, name)
VALUES (1, 187, 'H2O', 'Water');

INSERT INTO chemistry_molecule_atom_containment (amount, atom_atomic_number, molecule_id)
VALUES (2, 1, 1);
INSERT INTO chemistry_molecule_atom_containment (amount, atom_atomic_number, molecule_id)
VALUES (1, 8, 1);