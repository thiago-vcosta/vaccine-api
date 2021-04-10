INSERT INTO tb_user (name, email, cpf, birth_date) VALUES ('Marie Skłodowska Curie', 'marie.curie@gmail.com', '68157724465', TIMESTAMP WITH TIME ZONE '1867-11-07T15:17:59.0Z');
INSERT INTO tb_user (name, email, cpf, birth_date) VALUES ('Tarsila de Aguiar do Amaral', 'tarlsila@gmail.com', '43178073272', TIMESTAMP WITH TIME ZONE '1886-09-01T08:51:16.0Z');
INSERT INTO tb_user (name, email, cpf, birth_date) VALUES ('Chaya Pinkhasivna Lispector', 'clarice@gmail.com', '12700338758', TIMESTAMP WITH TIME ZONE '1920-12-10T01:50:34.0Z');

INSERT INTO tb_records (vaccine_Name, applied_Date, user_id) VALUES ('Sarampo', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', 1);
INSERT INTO tb_records (vaccine_Name, applied_Date, user_id) VALUES ('Rubéola', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', 1);
INSERT INTO tb_records (vaccine_Name, applied_Date, user_id) VALUES ('Polio', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', 2);
INSERT INTO tb_records (vaccine_Name, applied_Date, user_id) VALUES ('Sars-Cov2', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', 3);
