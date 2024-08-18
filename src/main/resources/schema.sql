DROP TABLE IF EXISTS books;
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    isbn VARCHAR(255),
    publicationDate DATE,
    authorName VARCHAR(255)
);