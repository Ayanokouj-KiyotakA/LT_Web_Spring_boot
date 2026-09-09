package h1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import h1.entity.Category;
import h1.repository.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService {

	private final ICategoryRepository categoryRepository;

	public CategoryService(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> search(String keyword) {
		if (!StringUtils.hasText(keyword)) {
			return findAll();
		}
		return categoryRepository.findByCategorynameContainingIgnoreCase(keyword.trim());
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

}
