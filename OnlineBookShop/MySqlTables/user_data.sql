USE book_App_Data;
DROP TABLE IF EXISTS user_data;
CREATE TABLE user_data(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
email VARCHAR(45),
phoneNO VARCHAR(45),
password VARCHAR(45),
address VARCHAR(45),
city VARCHAR(45),
state VARCHAR(45),
pin VARCHAR(45)
)


