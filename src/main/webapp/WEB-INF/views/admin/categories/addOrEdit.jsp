<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>

<h2>${category.edit ? 'Sua danh muc' : 'Them danh muc moi'}</h2>

<%-- Hien loi validation (@Valid) neu co, doc truc tiep tu BindingResult ma
     Spring MVC tu dat vao request attribute, khong can taglib rieng --%>
<c:set var="errors" value="${requestScope['org.springframework.validation.BindingResult.category']}" />
<c:if test="${not empty errors.allErrors}">
	<div class="alert alert-danger">
		<ul class="mb-0">
			<c:forEach items="${errors.allErrors}" var="err">
				<li>${err.defaultMessage}</li>
			</c:forEach>
		</ul>
	</div>
</c:if>

<form action="<c:url value='/admin/categories/saveOrUpdate'/>" method="post">
	<input type="hidden" name="categoryId" value="${category.categoryId}">
	<input type="hidden" name="edit" value="${category.edit}">

	<div class="mb-3">
		<label class="form-label">Ten danh muc</label>
		<input type="text" name="categoryname" class="form-control" value="${category.categoryname}">
	</div>

	<div class="mb-3">
		<label class="form-label">Hinh anh (duong dan/URL)</label>
		<input type="text" name="images" class="form-control" value="${category.images}">
	</div>

	<div class="mb-3">
		<label class="form-label">Trang thai</label>
		<select name="status" class="form-select">
			<option value="1" ${category.status == 1 ? 'selected' : ''}>Hien thi</option>
			<option value="0" ${category.status == 0 ? 'selected' : ''}>An</option>
		</select>
	</div>

	<a href="<c:url value='/admin/categories'/>" class="btn btn-secondary">Quay lai</a>
	<button type="submit" class="btn btn-primary">
		<c:choose>
			<c:when test="${category.edit}">Cap nhat</c:when>
			<c:otherwise>Luu</c:otherwise>
		</c:choose>
	</button>
</form>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>
