<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	var frm = $("form");
	
	$("button").on("click", function(e) {
		e.preventDefault();
		var operation = $(this).data("oper");
		
		if (operation === "remove") {
			frm.attr("action", "remove.do")
			
		} else if (operation === "list") {
			frm.attr("action", "list.do").attr("method", "get");
			
			var pageNumTag = $("input[name='pageNum']");.clone();
			var amountTag = $("input[name='amount']").clone();
			var keywordTag = $("input[name='keyword']").clone();
			var typeTag = $("input[name= 'type']").clone();
			
			frm.empty();
			frm.append(pageNumTag);
			frm.append(amountTag);
			frm.append(keywordTag);
			frm.append(typeTag);
			//frm.html(""); //empty나 html("")중 선택해서 하기
			/* self.location = "list.do"
			return; */
		}
		frm.submit();
	});
});
</script>
<div class="row">
	<div class="col-lg-12">
		<div class="p-5">
			<div class="text-center">
				<h1 class="h4 text-gray-900 mb-4">Board Modify</h1>
			</div>
			<form class="user" name="frm" action="modify.do" method="POST">
				<input type="hidden" id="bno" name="bno" value="${board.bno}">
				<input type='hidden' name='type' value='${cri.type}'/>
				<input type='hidden' name='keyword' value='${cri.keyword}'/>
				<input type="hidden" id="pageNum" name="pageNum" value="${cri.pageNum}">
				<input type="hidden" id="amount" name="amount" value="${cri.amount}">
				<div class="form-group">
					<div class="col-sm-10 mb-3 mb-sm-0">
					<label>Title</label>
						<input type="text" name="title" class="form-control form-control-user" value="${board.title}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label>Writer</label>
							<p>${board.writer}</p>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label>RegDate</label>
						<p>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.regDate}"/>
						</p>
					</div>					
				</div>
				<div class="form-group">
					<div class="col-sm-10">
					<label>Content</label>
						<textarea name="content" rows="3" class="form-control">${board.content}</textarea>
					</div>
				</div>
				<button type="submit" data-oper="modify" class="btn btn-default">Edit</button>
				<button type="submit" data-oper="remove" class="btn btn-danger">Delete</button>
				<button type="submit" data-oper="list" class="btn btn-info">Go List</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>