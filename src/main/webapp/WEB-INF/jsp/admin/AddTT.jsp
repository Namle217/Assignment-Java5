<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
	<div id="bar2" class="title-bar">
		<p>THÊM THÀNH TÍCH</p>
	</div>
<span style="color: red">${mess }</span>
	<div id="form-info">
		<form:form action="/Record/insertR" method="Post" modelAttribute="record">
			<label for="">Mã Nhân Viên</label>
			<label>${staff1.id }</label>
			<label for="">Tên Nhân Viên</label>
			<label>${staff1.name }</label>
			<form:hidden path="staff.id"/>
			<label for="">Loại Thành Tích</label>
			
			<div class="form-check">
				<form:radiobutton class="form-check-input" path="type"
					value="true" label="Khen Thưởng" />
				<form:radiobutton class="form-check-input" path="type"
					value="false" label="Kỷ Luật" />
			</div>
			<label for="">Lý Do</label>
			<form:textarea path="reason" class="form-control" name="" id="" rows="3"></form:textarea>

			<div>
				<button name = "btnInsert" class="btn-hover color-1">GHI NHẬN</button>
			</div>
		</form:form>
	</div>
</body>