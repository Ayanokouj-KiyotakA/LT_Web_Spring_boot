package h1.service;

import java.util.List;
import java.util.Optional;

import h1.entity.Category;

public interface ICategoryService {

	List<Category> findAll();

	List<Category> search(String keyword);

	Optional<Category> findById(Integer id);

	Category save(Category category);

	void deleteById(Integer id);

}
