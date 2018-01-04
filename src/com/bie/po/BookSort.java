package com.bie.po;

/***
 * 图书类别的实体类
 * @author Administrator
 *
 */
public class BookSort {

	//bookSortId bookSortName bookSortExtend bookSortMark
	private int bookSortId;//图书类别编号
	private String bookSortName;//图书类别名称
	private String bookSortExtend;//图书类别扩展字段
	private String bookSortMark;//图书类型标识
	
	public int getBookSortId() {
		return bookSortId;
	}
	public void setBookSortId(int bookSortId) {
		this.bookSortId = bookSortId;
	}
	public String getBookSortName() {
		return bookSortName;
	}
	public void setBookSortName(String bookSortName) {
		this.bookSortName = bookSortName;
	}
	public String getBookSortExtend() {
		return bookSortExtend;
	}
	public void setBookSortExtend(String bookSortExtend) {
		this.bookSortExtend = bookSortExtend;
	}
	public String getBookSortMark() {
		return bookSortMark;
	}
	public void setBookSortMark(String bookSortMark) {
		this.bookSortMark = bookSortMark;
	}
	public BookSort(int bookSortId, String bookSortName, String bookSortExtend, String bookSortMark) {
		super();
		this.bookSortId = bookSortId;
		this.bookSortName = bookSortName;
		this.bookSortExtend = bookSortExtend;
		this.bookSortMark = bookSortMark;
	}
	@Override
	public String toString() {
		return "BookSort [bookSortId=" + bookSortId + ", bookSortName=" + bookSortName + ", bookSortExtend="
				+ bookSortExtend + ", bookSortMark=" + bookSortMark + "]";
	}
	public BookSort() {
		super();
	}
	
	
}
