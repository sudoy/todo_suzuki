<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--上-->
<jsp:include page="header.jsp" />

	<div class="container">

		<!--メッセージ-->
		<jsp:include page="message.jsp" />

		<!--登録フォーム-->
		<div class="header-bottom">
 			<h4 class="h-margin-off"><strong>登録フォーム</strong></h4>
		</div>
		<form class="form-horizontal" method="post" action="entry.html">

			<div class="form-group">
				<label for="title" class="col-sm-offset-1 col-sm-1 control-label">題名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="題名">
				</div>
			</div>

			<div class="form-group">
				<label for="details" class="col-sm-offset-1 col-sm-1 control-label">詳細</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="details" name="details" placeholder="詳細"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">重要度</label>
				<div class="col-sm-1">
					<div class="radio">
						<label>
	 						<input type="radio" name="importance" value="3" checked>★★★
						</label>
					</div>
					<div class="radio">
						<label>
	 						<input type="radio" name="importance" value="2">★★
						</label>
					</div>
					<div class="radio">
						<label>
	 						<input type="radio" name="importance" value="1">★
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="limit" class="col-sm-offset-1 col-sm-1 control-label">期限</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="limit" name="limit" placeholder="期限">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default btn-gray" onclick="location.href='index.html'">キャンセル</button>
					<button type="submit" class="btn btn-info">追加</button>
				</div>
			</div>

		</form><!--form class="form-horizontal"-->

	</div><!--div class="container"-->

<!--下-->
<jsp:include page="footer.jsp" />