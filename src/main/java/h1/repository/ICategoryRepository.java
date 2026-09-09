package h1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import h1.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	// Spring Data JPA tu sinh cau query tu ten ham (derived query) - dung cho
	// chuc nang tim kiem theo ten danh muc, khong phan biet hoa/thuong.
	List<Category> findByCategorynameContainingIgnoreCase(String keyword);

}
