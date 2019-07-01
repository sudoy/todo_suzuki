<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty complete}">
<div class="alert alert-success alert-dismissible" role="alert">
	<button type="submit" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<h4><strong> 完了しました！</strong></h4>
	<ul>
		<li>${complete}</li>
	</ul>
</div>
</c:if>

<c:if test="${not empty error}">
<div class="alert alert-danger alert-dismissible background-pink" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<h4><strong> エラーが発生しました！</strong></h4>
	<ul>
		<c:forEach var="e" items="${error}">
			<li>${e}</li>
		</c:forEach>
	</ul>
</div>
</c:if>