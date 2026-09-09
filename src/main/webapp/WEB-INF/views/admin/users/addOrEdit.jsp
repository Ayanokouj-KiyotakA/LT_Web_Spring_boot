<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>

<h2>${user.edit ? 'Sua nguoi dung' : 'Them nguoi dung moi'}</h2>

<c:set var="errors" value="${requestScope['org.springframework.validation.BindingResult.user']}" />
<c:if test="${not empty errors.allErrors}">
	<div class="alert alert-danger">
		<ul class="mb-0">
			<c:forEach items="${errors.allErrors}" var="err">
				<li>${err.defaultMessage}</li>
			</c:forEach>
		</ul>
	</div>
</c:if>

<form action="<c:url value='/admin/users/saveOrUpdate'/>" method="post">
	<input type="hidden" name="id" value="${user.id}">
	<input type="hidden" name="edit" value="${user.edit}">

	<div class="mb-3">
		<label class="form-label">Ten dang nhap</label>
		<input type="text" name="userName" class="form-control" value="${user.userName}">
	</div>

	<div class="mb-3">
		<label class="form-label">Ho ten</label>
		<input type="text" name="fullName" class="form-control" value="${user.fullName}">
	</div>

	<div class="mb-3">
		<label class="form-label">Email</label>
		<input type="email" name="email" class="form-control" value="${user.email}">
	</div>

	<div class="mb-3">
		<label class="form-label">Mat khau
			<c:if test="${user.edit}">
				<small class="text-muted">(de trong neu khong doi mat khau)</small>
			</c:if>
		</label>
		<input type="password" name="passWord" class="form-control" value="">
	</div>

	<div class="mb-3">
		<label class="form-label">Dien thoai</label>
		<input type="text" name="phone" class="form-control" value="${user.phone}">
	</div>

	<div class="mb-3">
		<label class="form-label">Vai tro</label>
		<select name="roleid" class="form-select">
			<option value="1" ${user.roleid == 1 ? 'selected' : ''}>Admin</option>
			<option value="2" ${user.roleid == 2 ? 'selected' : ''}>Khach hang</option>
		</select>
	</div>

	<div class="mb-3">
		<label class="form-label">Trang thai</label>
		<select name="active" class="form-select">
			<option value="1" ${user.active == 1 ? 'selected' : ''}>Da kich hoat</option>
			<option value="0" ${user.active == 0 ? 'selected' : ''}>Chua kich hoat</option>
		</select>
	</div>

	<a href="<c:url value='/admin/users'/>" class="btn btn-secondary">Quay lai</a>
	<button type="submit" class="btn btn-primary">
		<c:choose>
			<c:when test="${user.edit}">Cap nhat</c:when>
			<c:otherwise>Luu</c:otherwise>
		</c:choose>
	</button>
</form>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>
