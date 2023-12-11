<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
	<div class="row">
		<div class="col-lg-12">
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">Board Register</h1>
				</div>
				<form class="user" name="frm" action="create.do" method="POST">
					<div class="form-group">
						<div class="col-sm-10 mb-3 mb-sm-0">
						<label>Title</label>
							<input type="text" name="title" class="form-control form-control-user" 
								placeholder="제목을 입력하세요">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
						<label>Writer</label>
							<input type="text" name="writer" class="form-control form-control-user"
								placeholder="이름을 입력하세요">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
						<label>Content</label>
							<textarea name="content" rows="3" class="form-control"></textarea>
						</div>
					</div>
					<button type="submit" class="btn btn-default">Register</button>
					<button type="reset" class="btn btn-default">Reset</button>
					<button type="button" onclick="location.href='list.do'">Go List</button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="../includes/footer.jsp"%>