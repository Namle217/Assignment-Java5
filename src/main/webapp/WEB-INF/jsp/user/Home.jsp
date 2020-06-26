<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div id="bar1" class="title-bar">
		<p>TOP 10 GƯƠNG MẶT XUẤT SẮC NHẤT</p>
	</div>

	<div class="row">
		<c:forEach var="d" items="${top10 }">

			<div class="cols">
				<img src="/files/${d[2] }" alt="">
				<p>${d[0] }</p>
				<p>PHÒNG ${d[1] }</p>
			</div>
		</c:forEach>
	</div>

</body>
