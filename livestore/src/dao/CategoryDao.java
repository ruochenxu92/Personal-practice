package dao;

import java.util.List;

import domain.Category;

public interface CategoryDao {

	void add(Category category);

	Category find(String id);

	List<Category> getAll();

}