package h1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import h1.entity.Category;
import h1.model.CategoryModel;
import h1.service.ICategoryService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	private final ICategoryService categoryService;

	public CategoryController(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// GET /admin/categories?keyword=... -> danh sach (co ho tro tim kiem)
	@RequestMapping("")
	public String list(@RequestParam(value = "keyword", required = false) String keyword, ModelMap model) {
		List<Category> list = categoryService.search(keyword);
		model.addAttribute("categories", list);
		model.addAttribute("keyword", keyword);
		return "admin/categories/list";
	}

	// Hien form them moi
	@GetMapping("add")
	public String add(ModelMap model) {
		CategoryModel cateModel = new CategoryModel();
		cateModel.setEdit(false);
		model.addAttribute("category", cateModel);
		return "admin/categories/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@Valid @ModelAttribute("category") CategoryModel cateModel, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "admin/categories/addOrEdit";
		}

		Category entity = new Category();
		BeanUtils.copyProperties(cateModel, entity);
		categoryService.save(entity);

		String message = cateModel.isEdit() ? "Da cap nhat danh muc!" : "Da them danh muc moi!";
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/admin/categories";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap model, RedirectAttributes redirectAttributes) {
		Optional<Category> optCategory = categoryService.findById(id);
		if (optCategory.isPresent()) {
			Category entity = optCategory.get();
			CategoryModel cateModel = new CategoryModel();
			BeanUtils.copyProperties(entity, cateModel);
			cateModel.setEdit(true);
			model.addAttribute("category", cateModel);
			return "admin/categories/addOrEdit";
		}
		redirectAttributes.addFlashAttribute("message", "Danh muc khong ton tai!");
		return "redirect:/admin/categories";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		categoryService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Da xoa danh muc!");
		return "redirect:/admin/categories";
	}

}
