USE book_App_Data;
DROP TABLE IF EXISTS order_data;
create table order_data(
order_id int primary key auto_increment,
user_id int,
user_name varchar(50),
user_email varchar(50),
user_address varchar(100),
user_city varchar(50),
user_state varchar(50),
user_pin varchar(50),
user_phoneNo varchar(50),
book_name varchar(50),
book_author varchar(50),
book_price varchar(50),
payment_type varchar(50)
)

