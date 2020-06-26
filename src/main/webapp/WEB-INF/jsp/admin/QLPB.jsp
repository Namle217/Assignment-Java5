<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <body>
    	<div id = "bar2" class ="title-bar">
              <p>DANH SÁCH PHÒNG BAN</p>
            </div>
            <div>
            <form:form action="/QLPB/insert">
              <button name="btn_Insert" class="btn-hover color-1">THÊM MỚI</button>
              <span style="color: red">${mess }</span>
              </form:form>
            </div>
            <div class="table">
              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>MÃ PHÒNG BAN</th>
                    <th>TÊN PHÒNG BAN</th>
                    <th>SỬA</th>
                    <th>XÓA</th>
                  </tr>
                  </thead>
                  <tbody>
  
                    <c:set var ="count" value="0" />
                    <c:forEach var="d" items="${list }">
                  
                    	<tr>
                    		<c:set var ="count" value="${count+1 }"/>
                    		<td>${count }</td>
                    		<td>${d.id }</td>
                    		<td>${d.name }</td>
                    		<td><a href="/QLPB/update${d.id}"><button type="submit" name="btnUpdate" value="update" class="btn-hover color-2">SỬA TÊN</button></a></td>
                      		<td><a href="/QLPB/delete${d.id}"><button type="submit" name="btnDelete" value="delete" class="btn-hover color-3">XÓA</button></a></td>           	
                    	</tr>
                  
                    </c:forEach>
                   
                  </tbody>
              </table>
            </div>
    </body>