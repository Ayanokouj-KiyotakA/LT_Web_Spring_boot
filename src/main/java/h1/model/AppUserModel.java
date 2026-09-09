package h1.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AppUserModel {

	private int id;

	@NotBlank(message = "Ten dang nhap khong duoc de trong")
	private String userName;

	@NotBlank(message = "Ho ten khong duoc de trong")
	private String fullName;

	@NotBlank(message = "Email khong duoc de trong")
	@Email(message = "Email khong dung dinh dang")
	private String email;

	// Bat buoc nhap khi them moi; khi sua co the de trong = giu mat khau cu
	// (kiem tra logic nay o Controller vi @NotBlank se chan ca luc sua).
	private String passWord;

	private String phone;

	private int roleid;

	private int active;

	// Xem chu thich trong CategoryModel: dat ten field la "edit", KHONG phai
	// "isEdit", de JSP EL hoat dong dung (${user.edit}).
	private boolean edit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

}
