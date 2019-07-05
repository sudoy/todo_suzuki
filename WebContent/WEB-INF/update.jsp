<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="todo.utils.HTMLUtils" %>

<!--上-->
<jsp:include page="header.jsp"><jsp:param name="page" value="index.html" /></jsp:include>

	<div class="container">

		<!--メッセージ-->
		<jsp:include page="message.jsp" />

		<!--更新フォーム-->
		<div class="header-bottom">
 			<h4 class="h-margin-off"><strong>更新フォーム</strong></h4>
		</div>
		<form class="form-horizontal" method="post" action="update.html">

			<div class="form-group">
				<label for="title" class="col-sm-offset-1 col-sm-1 control-label">題名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="題名" value="${form.title}">
				</div>
			</div>

			<div class="form-group">
				<label for="detail" class="col-sm-offset-1 col-sm-1 control-label">詳細</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" placeholder="詳細" id="detail" name="detail">${form.detail}</textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">重要度</label>
				<div class="col-sm-1">
					<div class="radio">
						<label>${HTMLUtils.createRadioTags(3,form.importance)}★★★</label>
					</div>
					<div class="radio">
						<label>${HTMLUtils.createRadioTags(2,form.importance)}★★</label>
					</div>
					<div class="radio">
						<label>${HTMLUtils.createRadioTags(1,form.importance)}★</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="limit" class="col-sm-offset-1 col-sm-1 control-label">期限</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="limit" name="limitTime" placeholder="期限" value="${form.limitTime}">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">ステータス</label>
				<div class="col-sm-2">
					<div class="radio">
						<label>${HTMLUtils.createStatusTags(0,form.status)}未完了</label>
					</div>
					<div class="radio">
						<label>${HTMLUtils.createStatusTags(1,form.status)}完了</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" name="listId" value="${form.listId}">
					<button type="button" class="btn btn-default" onclick="location.href='index.html'">キャンセル</button>
					<button type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 更新
					</button>
					<button type="button" class="btn btn-danger pull-right" onclick="location.href='delete?listId=${form.listId}'">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 削除
					</button>
				</div>
			</div>

		</form><!--form class="form-horizontal"-->

	</div><!--div class="container"-->

<!--下-->
<jsp:include page="footer.jsp" />