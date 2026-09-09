package h1.model;

import jakarta.validation.constraints.NotBlank;

/**
 * View-model dung rieng cho form them/sua Category (tach voi Entity de gan
 * them validation va co flag "edit" phan biet 2 che do cua form).
 */
public class CategoryModel {

	private int categoryId;

	@NotBlank(message = "Ten danh muc khong duoc de trong")
	private String categoryname;

	private String images;

	private int status;

	// LUU Y: dat ten field la "edit" (khong phai "isEdit"). Neu dat ten
	// "isEdit", getter chuan JavaBean se la isEdit() nhung JavaBeans
	// Introspector lai hieu day la getter cua thuoc tinh "edit" (bo tiep dau
	// "is"), khien JSP EL ${category.isEdit} khong tim thay thuoc tinh - phai
	// dung ${category.edit}. Dat thang ten la "edit" cho khoi nham.
	private boolean edit;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

}
