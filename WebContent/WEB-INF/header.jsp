<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Todoリスト</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="css/mystyle.css" rel="stylesheet">
</head>
<body class="background-gray">

<nav class="navbar navbar-default background-white">
	<div class="container">

		<div class="navbar-header">
			<a class="navbar-brand" href="${param.page}">Todoリスト</a>
		</div>

		<%--ログアウトのボタン--%>
		<c:if test="${param.page == 'index.html'}">
		<form class="navbar-form navbar-right">
			<div class="dropdown">
				<button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					${username} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="logout">ログアウト</a></li>
				</ul>
			</div>
		</form>
		</c:if>

	</div>
</nav>