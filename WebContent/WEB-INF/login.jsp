<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--上-->
<jsp:include page="header.jsp"><jsp:param name="page" value="login.html" /></jsp:include>

	<div class="panel panel-default col-sm-offset-3 col-sm-6 login-form">
	  <div class="panel-body">
	    	<h4 class="login-title">ログイン</h4>

	    	<!--メッセージ-->
			<jsp:include page="message.jsp" />

			<form class="form-horizontal" method="post" action="login.html">
				<div class="form-group">
					<label for="Email" class="col-sm-4 control-label">メールアドレス</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" id="Email" name="mail" value="${form.inputMail}" placeholder="メールアドレス">
					</div>
				</div>
				<div class="form-group">
					<label for="Password" class="col-sm-4 control-label">パスワード</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="Password" name="password" placeholder="パスワード">
					</div>
				</div>

				<div class="pull-right login-button">
					<button type="submit" class="btn btn-info">
						<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> ログイン
					</button>
				</div>
			</form>

		</div>
	</div>

<!--下-->
<jsp:include page="footer.jsp" />