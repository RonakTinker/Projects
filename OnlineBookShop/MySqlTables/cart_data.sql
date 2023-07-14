USE book_App_Data;
DROP TABLE IF EXISTS cart_data;
CREATE TABLE cart_data(
cart_id INT PRIMARY KEY AUTO_INCREMENT,
book_id INT,
user_id INT,
book_name VARCHAR(45),
book_author VARCHAR(45),
book_price VARCHAR(45)
)

