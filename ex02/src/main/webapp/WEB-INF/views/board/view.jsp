<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<script type="text/javascript" src="/resources/js/board/reply.js"></script>
<script type="text/javascript">
	console.log("==============");
	console.log("JS TEST");
	var bnoValue = '<c:out value="${board.bno}"/>';
	
	replyService.getList({bno: bnoValue, page:1}, function(list) {
		for(var i= 0, len = list.length | 10; i < len; i++){
			console.log(list[i]);
		}
	});
	
	//for replyService add test
/* 	replyService.add(
		{replyContent:"JS Test", replyer:"tester", bno:bnoValue}
		,
		function(result){
			alert("RESULT: " + result);
		}
	); */
	
/* 	replyService.remove(5, function(count) {
		console.log("remove"+ count);
		
		if (count == "success") {
			alert("REMOVED");
		}
	},  function(err) {
		alert('ERROR...');
	});
	
	replyService.modify({
		rno : 6
		, bno : bnoValue
		, replyContent : "Modified Reply..."
	}, function(result){
		alert("수정 완료...");
	})
	 */
	 
	replyService.get(10, function(data){
		console.log(data);
	});

	$(document).ready(function() {
		console.log(replyService);
		var bnoValue = '<c:out value="${board.bno}"/>';
		var replyUL = $(".chat");
		
		var frm = $("#frm");
		var frmN = $("form[name=frm]");
		
		$("button[data-oper='modify']").on("click", function(){
			frm.attr("action", "edit.do");
			frm.attr("method", "get").submit();
		});
		
		$("button[data-oper='list']").on("click", function(){
			frm.find("#bno").remove();
			frm.attr("action", "list.do")
			frm.submit();
		});
		
		showList(1);
		
		function showList(page) {
			replyService.getList({bno:bnoValue, page:page||1}
				, function(list) {
					var str = "";
					if(list == null || list.length == 0){
						replyUL.html("");
						return;
					}
					
					for(var i=0, len = list.length||0; i<len; i++) {
						str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
						str +=" <div><div class='header'><strong class='primary-font'>"
								+list[i].replyer+"</strong>";
						str +="	<small class='pull-right text-muted'>"
								+replyService.displayTime(list[i].regDate)+"</small></div>";
						str +=" <p>"+list[i].replyContent+"</p></div></li>";
					}
				replyUL.html(str);	
			});
		}
	});
</script>
	<div class="row row-cols-1">
		<div class="col-lg-12">
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">Board Register</h1>
				</div>
				<div class="form-group">
					<div class="col-sm-10 mb-3 mb-sm-0">
						<label>Title</label>
						<p>${board.title}</p>
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
						<p>${board.regDate}</p>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<label>Content</label>
						<p>${board.content}</p>
					</div>
				</div>
				<form id=frm class="user" name="frm">
					<input type="hidden" id="bno" name="bno" value="${board.bno}">
					<input type='hidden' name='type' value='${cri.type}'/>
					<input type='hidden' name='keyword' value='${cri.keyword}'/>
					<input type='hidden' name='pageNum' value="<c:out value="${cri.pageNum}"/>">
					<input type='hidden' name='amount' value="<c:out value="${cri.amount}"/>">
				</form>
				<button type="button" class="btn btn-default" data-oper="modify">Modify</button>
				<button type="button" class="btn btn-default" data-oper="list">Go List</button>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
				</div>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2018-01-01 13:13 </small>
							</div>
							<p>Good job!</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
<%@ include file="../includes/footer.jsp"%>