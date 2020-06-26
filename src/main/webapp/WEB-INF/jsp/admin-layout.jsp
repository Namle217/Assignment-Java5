<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Trang Chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/qlpb.css">
    <link rel="stylesheet" href="/css/hsnv.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  	<base href="${pageContext.servletContext.contextPath }">
  </head>
  <body>
    <div id="container">
      <div id = "menu">
        <ul>
          <li><a href="/home/login">TRANG CHỦ</a></li>
          <li><a href="/QLPB/list">QUẢN LÝ PHÒNG BAN</a></li>
          <li><a href="/QLNV/list">QUẢN LÝ NHÂN VIÊN</a></li>
          <li><a href="/Record/insert">THÊM THÀNH TÍCH</a></li>
          <li><a href="/Record/toStaff">THỐNG KÊ NHÂN VIÊN</a></li>
          <li><a href="/Record/toDepart">THỐNG KÊ PHÒNG BAN</a></li>
        </ul>
      </div><!--menu-->
      <div id = "content">
        <div id = "header">
            <img src="/img/logo.png" alt="">
        </div><!--header-->
        <div id = "call-to-action">Team SoloMid (TSM hay ngắn gọn là SoloMid) là một đội thể thao điện tử của Mỹ. Được thành lập vào tháng 9 năm 2009 bởi 2 anh em người gốc Việt chơi Liên Minh Huyền Thoại là Andy "Reginald" Dinh và Daniel "Dan Dinh" Dinh, những người trước đó đã thành lập trang web game cho cộng đồng SoloMid.net. TSM hiện tại đã có các đội game ở các mặt trận Liên Minh Huyền Thoại,  Hearthstone: Heroes of Warcraft, Call of Duty, Super Smash Bros., và Counter-Strike: Global Offensive.</div><!--action-->
        <div id = "main-content">
          <jsp:include page="${param.view}"></jsp:include>

        </div>
        <div id = "footer">
          <p>
            <i class="fa fa-copyright" aria-hidden="true">TSM</i>
          </p>
        </div>
      </div><!--content-->
    </div><!--container-->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>