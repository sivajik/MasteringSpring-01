package com.mastspring.lesson01;

public class VillageLibrary {
	private Book[] books;
	
	VillageLibrary(Book[] b) {
		books = b;
	}
	
	public void printCatalog() {
		for (Book book : books) {
			System.out.println(book.name + " Costs: " + book.price);
			for (Author author: book.authors) {
				System.out.println("Author: " + author.authorName + " From " + author.address);
			}
		}
	}
}

class Book{
	String name;
	Double price;
	Author[] authors;
}

class Author {
	String authorName;
	String address;
}