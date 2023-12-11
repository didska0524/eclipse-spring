<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<%-- <jsp:include page="../includes/header.jsp"> --%>
<<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}" />';
		$("#a")
		
		checkModal (result);
		
		$("#regBtn").on("click", function(){
			self.location="write.do";
		});
		
		var frm=$("#frm");
		$(".paginate_button a").on("click", function(e) {
			e.preventDefault();
			console.log('click'); 
			frm.find("input[name='pageNum']").val($(this).attr("href"));
			frm.submit();
		});
		
		$(".move").on("click", function(e){
			e.preventDefault();
			frm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
			frm.attr("action","/board/view.do");
			frm.submit();
		});
		
		$("#frm button").on("click", function(e){
			if(!frm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			
			if(!frm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			
			frm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			frm.submit();
		});
		
		function checkModal (result) {
			if (result ==='') {
				return;
			}
			if (parseInt(result)> 0) {
				$(".modal-body").html("<p>게시글 " + parseInt(result) + " 번이 등록되었습니다.</p>");
			}
			$("#myModal").modal("show");
		}
	});
</script>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Tables</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
        href="https://datatables.net">official DataTables documentation</a>.</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <button id="regBtn" type="button" class="btn btn-xs pull-right">Register</button>
    <div class="card-body">
    	<form id='frm' action="/board/list.do" method='get'>
    		<select name='type'>
				<option value=""${pageMaker.cri.type == null ? " selected":"" }>--</option>
				<option value="T"${pageMaker.cri.type == 'T' ? " selected":"" }>제목</option>
				<option value="C"${pageMaker.cri.type == 'C' ? " selected":"" }>내용</option>
				<option value="W"${pageMaker.cri.type == 'W' ? " selected":"" }>작성자</option>
				<option value="TC"${pageMaker.cri.type == 'TC' ? " selected":"" }>제목 or 내용</options>
				<option value="TW"${pageMaker.cri.type == 'TW' ? " selected":"" }>제목 or 작성자 </option>
				<option value="TWC"${pageMaker.cri.type == 'TWC' ? " selected":"" }>제목 or 내용 or 작성자</option>
			</select>
			<input type=text name='keyword' value='${pageMaker.cri.keyword}'/>
			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
			<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
			<button class='btn btn-default'>Search</button>
		</form>
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>RegDate</th>
                    </tr>
                </thead>
                <tbody>
		            <c:forEach items="${list}" var="list"> <!-- 여기있는 var값이 -->
		                <tr>
		                    <td><a>${list.bno}</a></td> <!-- 여기 list. << 여기에 붙어야함 -->
		                    <td>
		                    	<a class="move" href="${list.bno}">${list.title}</a>
		                    </td> <!-- 게시물 제목 -->
		                    <td>${list.writer}</td> <!-- 작성자 -->
		                    <%-- <td>${list.regDate}</td> --%>
		                    <td>
		                    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${list.regDate}"/>
		                    </td> <!-- 등록 날짜 -->
		                </tr>
		            </c:forEach>
		        </tbody>

                <tfoot>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>RegDate</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
    <div class = "dataTables_pageinate paging_simple_numbers">
    	<ul class="pagination">
    		<c:if test="${pageMaker.prev}">
				<li class="paginate_button page-item previous">
					<a href="${pageMaker.startPage - 1}" class="page-link">Previous</a>
				</li>
			</c:if>
			
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
			<li class="paginate_button page-item${pageMaker.cri.pageNum == num ? ' active':''} ">
				<a href="${num}" class="page-link">${num}</a>
			</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next}">
				<li class="paginate_button page-item next">
					<a href="${pageMaker.endPage + 1}" class="page-link">Next</a>
				</li>
			</c:if>
    	</ul>
    </div>
</div>

<!-- Modal 추가 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModal Label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /. modal-dialog -->
</div>
<!--/.modal -->

<%@include file="../includes/footer.jsp" %>
<%-- <jsp:include page="../includes/footer.jsp"> --%>

