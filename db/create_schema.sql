CREATE TABLE books (
                       book_id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       rating DECIMAL(2,1) NOT NULL,
                       description TEXT NOT NULL,
                       language VARCHAR(255) NOT NULL,
                       isbn VARCHAR(255) NOT NULL,
                       book_format VARCHAR(255) NOT NULL,
                       edition VARCHAR(255) NOT NULL,
                       pages INT NOT NULL,
                       publisher VARCHAR(255) NOT NULL,
                       publish_date DATE NOT NULL,
                       first_publish_date DATE NOT NULL,
                       liked_percent DECIMAL(5,2) NOT NULL,
                       price DECIMAL(5,2) NOT NULL
);

CREATE TABLE authors (
                         author_id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE books_authors (
                               book_id INT NOT NULL,
                               author_id INT NOT NULL,
                               PRIMARY KEY (book_id, author_id),
                               FOREIGN KEY (book_id) REFERENCES books (book_id),
                               FOREIGN KEY (author_id) REFERENCES authors (author_id)
);
