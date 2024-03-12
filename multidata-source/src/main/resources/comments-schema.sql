CREATE TABLE IF NOT EXISTS comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL 
);

INSERT INTO comments (text, post_id) VALUES ('sdsdsd', 1);
INSERT INTO comments (text, post_id) VALUES ('sdsdsd', 1);

INSERT INTO comments (text, post_id) VALUES ('Oiii', 1);
INSERT INTO comments (text, post_id) VALUES ('Olá!!', 1);
