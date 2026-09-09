package h1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import h1.entity.AppUser;
import h1.model.AppUserModel;
import h1.service.IAppUserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/users")
public class AppUserController {

	private final IAppUserService userService;

	public AppUserController(IAppUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("")
	public String list(@RequestParam(value = "keyword", required = false) String keyword, ModelMap model) {
		List<AppUser> list = userService.search(keyword);
		model.addAttribute("users", list);
		model.addAttribute("keyword", keyword);
		return "admin/users/list";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		AppUserModel userModel = new AppUserModel();
		userModel.setEdit(false);
		userModel.setActive(1);
		model.addAttribute("user", userModel);
		return "admin/users/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@Valid @ModelAttribute("user") AppUserModel userModel, BindingResult result,
			RedirectAttributes redirectAttributes) {
		// Mat khau bat buoc khi them moi; khi sua duoc phep de trong = giu nguyen
		// mat khau cu (nen khong gan @NotBlank truc tiep tren field trong Model).
		if (!userModel.isEdit() && !StringUtils.hasText(userModel.getPassWord())) {
			result.addError(new FieldError("user", "passWord", "Mat khau khong duoc de trong khi tao moi"));
		}

		if (result.hasErrors()) {
			return "admin/users/addOrEdit";
		}

		AppUser entity;
		if (userModel.isEdit()) {
			// Lay lai entity cu tu DB de khong lam mat cac cot khong co tren form
			// (createdDate, otpCode, otpExpiredAt, avatar...)
			entity = userService.findById(userModel.getId()).orElse(new AppUser());
			String oldPassword = entity.getPassWord();
			BeanUtils.copyProperties(userModel, entity, "id", "passWord");
			entity.setId(userModel.getId());
			entity.setPassWord(StringUtils.hasText(userModel.getPassWord()) ? userModel.getPassWord() : oldPassword);
		} else {
			entity = new AppUser();
			BeanUtils.copyProperties(userModel, entity);
			entity.setCreatedDate(new java.util.Date());
		}
		userService.save(entity);

		String message = userModel.isEdit() ? "Da cap nhat nguoi dung!" : "Da them nguoi dung moi!";
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/admin/users";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap model, RedirectAttributes redirectAttributes) {
		Optional<AppUser> optUser = userService.findById(id);
		if (optUser.isPresent()) {
			AppUser entity = optUser.get();
			AppUserModel userModel = new AppUserModel();
			BeanUtils.copyProperties(entity, userModel);
			userModel.setPassWord(""); // khong hien mat khau cu ra form
			userModel.setEdit(true);
			model.addAttribute("user", userModel);
			return "admin/users/addOrEdit";
		}
		redirectAttributes.addFlashAttribute("message", "Nguoi dung khong ton tai!");
		return "redirect:/admin/users";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		userService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Da xoa nguoi dung!");
		return "redirect:/admin/users";
	}

}
