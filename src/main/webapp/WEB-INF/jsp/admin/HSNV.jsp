<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
	<div id="bar3" class="title-bar">
		<p>HỒ SƠ NHÂN VIÊN</p>
	</div>
	<span style="color: red">${mess }</span>
	<div id="form-info">
		<form:form action="/QLNV/Update" modelAttribute="staff" method="POST"  enctype="multipart/form-data">
			<label for="">Mã Nhân Viên</label><br>
			<label>${staff.id }</label>
				 <form:hidden path="id"/>
				 <br>
			
			<label for="">Họ Tên Nhân Viên</label>
			<form:input path="name" class="form-control" name="" id=""
				aria-describedby="helpId" placeholder="" />
			<label for="">Giới Tính</label>
			<div class="form-check">
				<form:radiobutton class="form-check-input" path="gender"
					value="true" label="Nam" />
				<form:radiobutton class="form-check-input" path="gender"
					value="false" label="Nữ" />
			</div>

			<div>
				<img src="/files/${staff.photo }" style="width: 183px; height: 275px"
					alt="">
			</div>
			<form:input path="photo"/>
			<div class="form-group">
				<label for=""></label> <input type="file" class="form-control-file"
					name="photo1" id="">
			</div>
			<div class="form-group">
				<label for="">Phòng Ban</label>

				<form:select class="form-control" path="depart.id" items="${listPB}"
					itemLabel="name" itemValue="id"></form:select>
			</div>
			<label for="">Lương</label>
			<form:input path="salary" class="form-control" name="" id=""
				aria-describedby="helpId" placeholder=""/>
			
			<label for="">Email</label>
			<form:input path="email" type="text" class="form-control" name="" id=""
				aria-describedby="helpId" placeholder=""/>
			<label for="">Số Điện Thoại</label>
			<form:input  path="phone" type="text" class="form-control" name="" id=""
				aria-describedby="helpId" placeholder=""/>
			<label for="">Ngày Sinh</label>
			<form:input  path="birthday" class="form-control" name="" id=""
				aria-describedby="helpId" placeholder=""/>

			<div>
			
				
				<button name="btnUpdate" class="btn-hover color-1">XÁC NHẬN</button>
				
			</div>
		</form:form>
	</div>
</body>