<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<div id="bar4" class="title-bar">
		<p>TẠO MỚI PHÒNG BAN</p>
	</div>
	<span style="color: red;">${mess }</span>
	<div id="form-info">
		<form:form action="/QLPB/insert" modelAttribute="depart" method="POST">
			<label for="">Mã PHÒNG BAN</label>
			<form:input
				path="id"
				class="form-control" 
				placeholder="Nhập mã phòng ban" />
			 <label for="">TÊN PHÒNG BAN</label>
			 <form:input
				path="name"
				class="form-control"
				placeholder="Nhập tên phòng ban"/> 

			<div>
				<button name="btnInsert" class="btn-hover color-1">XÁC NHẬN</button>
			</div>
		</form:form>
	</div>
</body>