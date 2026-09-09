<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>

<h2>Danh sach danh muc</h2>

<c:if test="${message != null}">
	<div class="alert alert-primary" role="alert">
		<i>${message}</i>
	</div>
</c:if>

<div class="d-flex justify-content-between mb-3">
	<form class="d-flex" method="get" action="<c:url value='/admin/categories'/>">
		<input type="text" name="keyword" class="form-control me-2" placeholder="Tim theo ten danh muc..."
			value="${keyword}">
		<button class="btn btn-outline-secondary" type="submit"><i class="fa fa-search"></i></button>
	</form>
	<a href="<c:url value='/admin/categories/add'/>" class="btn btn-success text-nowrap ms-2"><i
		class="fa fa-plus"></i> Them moi</a>
</div>

<table class="table table-striped table-bordered align-middle">
	<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>Ten danh muc</th>
			<th>Hinh anh</th>
			<th>Trang thai</th>
			<th>Hanh dong</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryname}</td>
				<td>${category.images}</td>
				<td>
					<c:choose>
						<c:when test="${category.status == 1}">
							<span class="badge bg-success">Hien thi</span>
						</c:when>
						<c:otherwise>
							<span class="badge bg-secondary">An</span>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a href="<c:url value='/admin/categories/edit/${category.categoryId}'/>"
						class="btn btn-outline-warning btn-sm">Sua</a>
					<a href="<c:url value='/admin/categories/delete/${category.categoryId}'/>"
						class="btn btn-outline-danger btn-sm"
						onclick="return confirm('Xoa danh muc nay?');">Xoa</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty categories}">
			<tr>
				<td colspan="5" class="text-center text-muted">Khong co danh muc nao</td>
			</tr>
		</c:if>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>
