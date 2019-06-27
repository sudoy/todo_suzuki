<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
				<tr>
					<td>1</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★★</td>
					<td>2015/06/20</td>
				</tr>
				<tr>
					<td>2</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★</td>
					<td>2015/06/22</td>
				</tr>
				<tr>
					<td>3</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★★</td>
					<td>2015/06/20</td>
				</tr>
				<tr>
					<td>4</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★</td>
					<td></td>
				</tr>
			</tbody>
		</table>

		<!--追加ボタン-->
		<div>
			<button type="button" class="btn btn-info" onclick="location.href='entry.html'">追加</button>
		</div>

	</div><!--div class="container"-->

<!--下-->
<jsp:include page="footer.jsp" />