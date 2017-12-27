package com.bie.po;

/**
 * 图书的实体类
 * @author Administrator
 *
 */
public class Book {
	//bookId bookName bookAuthor bookPrice bookType bookPublish bookSum bookMark
	private int bookId;//图书编号
	private String bookName;//图书名称
	private String bookAuthor;//图书作者
	private Double bookPrice;//图书价格
	private String bookType;//图书类型
	private String bookPublish;//图书出版社
	private int bookSum;//图书总数
	private String bookMark;//图书标识
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public int getBookSum() {
		return bookSum;
	}
	public void setBookSum(int bookSum) {
		this.bookSum = bookSum;
	}
	public String getBookMark() {
		return bookMark;
	}
	public void setBookMark(String bookMark) {
		this.bookMark = bookMark;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookType=" + bookType + ", bookPublish=" + bookPublish + ", bookSum=" + bookSum
				+ ", bookMark=" + bookMark + "]";
	}
	public Book(int bookId, String bookName, String bookAuthor, Double bookPrice, String bookType, String bookPublish,
			int bookSum, String bookMark) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookType = bookType;
		this.bookPublish = bookPublish;
		this.bookSum = bookSum;
		this.bookMark = bookMark;
	}
	public Book() {
		super();
	}
	
	
	
}
