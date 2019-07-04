<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="todo.utils.HTMLUtils" %>

<!--上-->
<jsp:include page="header.jsp"><jsp:param name="page" value="index.html" /></jsp:include>

	<div class="container">
	<form method="post" action="index.html">

		<!--メッセージ-->
		<jsp:include page="message.jsp" />

		<!--完了ボタン-->
		<div class="pull-left margin-bottom">
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 完了
			</button>
		</div>

		<!--追加ボタン-->
		<div class="pull-right margin-bottom">
			<button type="button" class="btn btn-info" onclick="location.href='entry.html'">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 追加
			</button>
		</div>

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
				<tr <c:if test="${list.display == 'hide'}">class="hide"</c:if>>
					<td>
						<div class="checkbox margin-off">
							<label>${HTMLUtils.createStatusCheckbox(list.status,list.listId)}<strong>${list.listId}</strong></label>
						</div>
					</td>
					<td><a href="update.html?listId=${list.listId}">${list.title}</a></td>
					<td>${list.importance}</td>
					<td>${list.limitTime}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

	</form>
	</div><!--div class="container"-->

<!--下-->
<jsp:include page="footer.jsp" />