INSERT INTO USER (id, user_id, password, name, email, create_date, modified_date) VALUES (1, 'starve', '1234', '스타브', 'starve@slipp.net', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO USER (id, user_id, password, name, email, create_date, modified_date) VALUES (2, 'kyu', '1234', 'kyu', 'kyu@slipp.net', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO QUESTION (id, writer_id, title, contents, create_date, modified_date, answer_count) VALUES (1, 1, '1234', 'test', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 0);
INSERT INTO QUESTION (id, writer_id, title, contents, create_date, modified_date, answer_count) VALUES (2, 1, 'test', 'test', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 0);
