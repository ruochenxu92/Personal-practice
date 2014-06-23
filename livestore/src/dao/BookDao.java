package dao;

import java.util.List;

import domain.Book;

public interface BookDao {

	void add(Book book);

	Book find(String id);

	int getTotalNumber();

	List<Book> getPageBook(int startIndex, int pageSize);


	List<Book> getPageBook(int startIndex, int pageSize, String category_id);

	int getTotalNumber(String category_id);


}