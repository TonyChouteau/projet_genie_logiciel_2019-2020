INSERT INTO Enseignant VALUES (1, 7), (2, 8), (3, 8), (4, 8), (5, 10), (7, 22), (8, 12.5), (13, 13), (14, 13), (55, 8), (56, 8), (24, 9.5), (28, 9.23);


INSERT INTO UE VALUES (1), (2), (4);



INSERT INTO GroupeEleve VALUES (1, 'info1_TD1'), (2, 'info1_TD2'),(3, 'snum1_TD'), (4, 'snum2_TD'),(5, 'info1'), (6, '1a'),(7, '2a'), (9, 'snum2_info2');


INSERT INTO Vacataire VALUES (42, 'Pico', 'Alex'), (1, 'Papico', 'Jean'), (66, 'Miclet', 'Laurent'), (4, 'Vacquant', 'Marc');

INSERT INTO FicheVacataire VALUES (1, 1), (2, 42), (3, 66), (4, 42);

INSERT INTO Maquette VALUES (1, 'info1'), (2, 'snum1'), (3, 'info2');



INSERT INTO Eleve VALUES (1, 1), (2, 2), (3, 2), (4, 3), (5, 2), (6, 1), (7, 3), (8, 3), (9, 3), (10, 2), (11, 1), (12, 3);



INSERT INTO EleveEstDansGroupe VALUES (1, 1, 1), (2, 5, 1), (3, 6, 1), (4, 3, 2), (5, 6, 2),  (6, 3, 3), (7, 6, 3),(8, 7, 4), (9, 9, 4), (10, 3, 5), (11, 6, 5), (12, 2, 6), (13, 5, 6), (14, 6, 6), (15, 7, 7), (16, 9, 7), (17, 7, 8), (18, 9, 8), (19, 7, 9), (20, 9, 9), (21, 3, 10), (22, 6, 10), (23, 1, 11), (24, 5, 11), (25, 7, 12), (26, 9, 12);



INSERT INTO Module VALUES (1, 'Mod1', FALSE, 'DS', 1), (2, 'Mod2', TRUE, 'CC+DS', 2), (3, 'Mod3', FALSE, 'DS', 1), (4, 'Mod4', TRUE, 'PROJET', 5), (5, 'Mod5', FALSE, 'PROJET', 1), (6, 'Mod6', TRUE, 'CC+DS', 7);



INSERT INTO AssoModMaq VALUES (1, 1, 1), (2, 2, 1),(3, 3, 2),(4, 1, 3), (5, 2, 4),(6, 1, 5),(7, 1, 6),(8, 2, 6);



INSERT INTO Intervention VALUES (1, 1, 1, 6, 4, 2, 0, 0, 0, 1, NULL, FALSE),(2, 1, 1, 4, 6, 6, 0, 0, 0, NULL , 2, TRUE),(3, 1, 2, 10, 10, 8, 0, 0, 0, NULL, 1, FALSE),(4, 3, 2, 4, 0, 6, 0, 0, 0, 1, NULL, TRUE), (5, 2, 6, 4, 0, 6, 0, 0, 0, NULL, 1, FALSE);


INSERT INTO Coefficient VALUES (1, 10, 10, 8, 1, NULL), (1, 14, 10, 8, 2, NULL), (2, 4, 0, 6, 2, NULL);





