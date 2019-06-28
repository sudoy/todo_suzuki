<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--上-->
<jsp:include page="header.jsp" />

	<div class="container">

		<!--メッセージ-->
		<jsp:include page="message.jsp" />

		<!--Todoリスト-->
		<table class="table table-border-top">
			<thead>
				<tr>
					<th class="col-xs-1 col-sm-1">#</th>
					<th class="col-xs-4 col-sm-4">題名</th>
					<th class="col-xs-2 col-sm-2">重要度</th>
					<th class="col-xs-3 col-sm-3">期限</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.listId}</td>
					<td><a href="update.html">${list.title}</a></td>
					<td>${list.importance}</td>
					<td>${list.limitTime}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<!--追加ボタン-->
		<div>
			<button type="button" class="btn btn-info" onclick="location.href='entry.html'">追加</button>
		</div>

	</div><!--div class="container"-->

<!--下-->
<jsp:include page="footer.jsp" />