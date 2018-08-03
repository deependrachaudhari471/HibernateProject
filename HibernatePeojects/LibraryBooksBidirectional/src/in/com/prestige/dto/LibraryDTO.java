package in.com.prestige.dto;

import java.util.Set;

public class LibraryDTO {
	private Integer libraryCode;
	private String libraryName;
	private Set booksID;

	public Integer getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(Integer libraryCode) {
		this.libraryCode = libraryCode;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public Set getBooksID() {
		return booksID;
	}

	public void setBooksID(Set booksID) {
		this.booksID = booksID;
	}
}
