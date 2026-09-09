<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>

<h2>Danh sach nguoi dung</h2>

<c:if test="${message != null}">
	<div class="alert alert-primary" role="alert">
		<i>${message}</i>
	</div>
</c:if>

<div class="d-flex justify-content-between mb-3">
	<form class="d-flex" method="get" action="<c:url value='/admin/users'/>">
		<input type="text" name="keyword" class="form-control me-2"
			placeholder="Tim theo ten dang nhap/ho ten/email..." value="${keyword}">
		<button class="btn btn-outline-secondary" type="submit"><i class="fa fa-search"></i></button>
	</form>
	<a href="<c:url value='/admin/users/add'/>" class="btn btn-success text-nowrap ms-2"><i class="fa fa-plus"></i>
		Them moi</a>
</div>

<table class="table table-striped table-bordered align-middle">
	<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>Ten dang nhap</th>
			<th>Ho ten</th>
			<th>Email</th>
			<th>Dien thoai</th>
			<th>Vai tro</th>
			<th>Trang thai</th>
			<th>Hanh dong</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.userName}</td>
				<td>${user.fullName}</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td>
					<c:choose>
						<c:when test="${user.roleid == 1}">Admin</c:when>
						<c:otherwise>Khach hang</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${user.active == 1}">
							<span class="badge bg-success">Da kich hoat</span>
						</c:when>
						<c:otherwise>
							<span class="badge bg-secondary">Chua kich hoat</span>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a href="<c:url value='/admin/users/edit/${user.id}'/>"
						class="btn btn-outline-warning btn-sm">Sua</a>
					<a href="<c:url value='/admin/users/delete/${user.id}'/>"
						class="btn btn-outline-danger btn-sm"
						onclick="return confirm('Xoa nguoi dung nay?');">Xoa</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty users}">
			<tr>
				<td colspan="8" class="text-center text-muted">Khong co nguoi dung nao</td>
			</tr>
		</c:if>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/common/footer.jspf"%>
