INSERT INTO users(birth_date, email, first_name, gender, last_name, nickname, password, registered_at)
VALUES (date'09.10.2003', 'avgystunpolek@gmail.com', 'Avhustyn', 1, 'Polek', 'avhhust', 'password', current_timestamp);

INSERT INTO roles(name) values('ADMIN');

INSERT INTO user_roles(user_id, role_id) values (1, 1);

INSERT INTO post_categories(name) VALUES ('ALL');

INSERT INTO posts(content, created_at, likes_count, brief_title, title, preview_image, views_count, author_id, category_id)
VALUES ('Content', current_timestamp, 0, 'Sample short description 1', 'Sample title 1', '', 0, 1, 1);

INSERT INTO posts(content, created_at, likes_count, brief_title, title, preview_image, views_count, author_id, category_id)
VALUES ('Content', current_timestamp, 0, 'Sample short description 2', 'Sample title 2', '', 0, 1, 1);

INSERT INTO posts(content, created_at, likes_count, brief_title, title, preview_image, views_count, author_id, category_id)
VALUES ('Content', current_timestamp, 0, 'Sample short description 3', 'Sample title 3', '', 0, 1, 1);