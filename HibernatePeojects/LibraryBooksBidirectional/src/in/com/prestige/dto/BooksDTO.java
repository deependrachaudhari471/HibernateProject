package in.com.prestige.dto;

public class BooksDTO {
   private Integer bookId;
   private String bookName;
   private String authorName;
   private Double price;
	private LibraryDTO libId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LibraryDTO getLibId() {
		return libId;
	}

	public void setLibId(LibraryDTO libId) {
		this.libId = libId;
	}
}
