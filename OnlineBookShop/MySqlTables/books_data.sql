USE book_App_Data;
DROP TABLE IF EXISTS books_data;
CREATE TABLE books_data(
book_id INT PRIMARY KEY AUTO_INCREMENT,
book_name VARCHAR(45),
book_author VARCHAR(45),
book_price VARCHAR(45),
book_category VARCHAR(45),
book_image VARCHAR(45),
user_id INT
)

