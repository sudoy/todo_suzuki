<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="todo.utils.HTMLUtils" %>
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

		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>

		<div class="navbar-header">
			<a class="navbar-brand" href="${param.page}">Todoリスト</a>
		</div>

		<c:if test="${param.page == 'index.html'}">
		<div class="collapse navbar-collapse padding-off" id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-right nav-btn-sm-margin" method="get" action="index.html">

				<!--表示切替-->
				<div class="btn-group form-group btn-group-sm" role="group" aria-label="...">
					<button type="submit" ${HTMLUtils.createButtonClass(0,display)} name="display" value="incomp">
						<span class="glyphicon glyphicon-repeat"></span> 未完了のみ
					</button>
					<button type="submit" ${HTMLUtils.createButtonClass(1,display)} name="display" value="all">
						<span class="glyphicon glyphicon-refresh"></span> すべて
					</button>
				</div>

				<!--ログアウトのボタン-->
				<div class="dropdown form-group btn-group-sm">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						${username} <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="logout">ログアウト</a></li>
					</ul>
				</div>

			</form>
		</div><!--div class="collapse navbar-collapse"-->
		</c:if>

	</div>
</nav>