package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookItems {
	
	@Id
	@GeneratedValue
	@Column(name ="ID")
	private int id;
	@Column(name ="GENRE")
	private String genre;
	@Column(name ="BOOKNAME")
	private String bookName;
	
	public BookItems() {
		super();
		
	}
	public BookItems(String genre, String bookName) {
		super();
		this.genre= genre;
		this.bookName = bookName;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String returnBookInfo() {
		return this.bookName + ":" + this.genre;
	}
	

}
