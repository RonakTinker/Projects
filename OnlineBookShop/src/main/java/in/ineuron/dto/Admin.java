package in.ineuron.dto;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	
	//declaring the variables for book details
	private Integer book_id;
	private String book_name;
	private String book_author;
	private String book_price;
	private String book_category;
	private String book_image;
	private String user_email;
	
	//extra variables for adding the books to cart
	private Integer cart_id;
	private Integer user_id;
	private Double total_price;
	
	//extra variables for getting the order details.
	private String user_name;
	private String payment_type;
	private Integer order_id;
	
	
	
	//setters and getters for book data.
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
			this.user_email = user_email;
	}
	
	
	
	//setters and getters for cart data data.
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	
	
	//setters and getters for order data .
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	
	
	@Override
	public String toString() {
		return "Admin [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_price=" + book_price + ", book_category=" + book_category + ", book_image=" + book_image
				+ ", user_email=" + user_email + "]";
	}


}
