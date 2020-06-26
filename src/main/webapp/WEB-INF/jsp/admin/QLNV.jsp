<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>
    	<div id = "bar2" class ="title-bar">
              <p>DANH SÁCH NHÂN VIÊN</p>
            </div>
             <form:form action="/QLNV/insert">
              <button name="btn_Insert" class="btn-hover color-1">THÊM MỚI</button>
              <span style="color: red">${mess }</span>
              </form:form>
            <div class="table">
              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>MÃ SỐ</th>
                    <th>HỌ TÊN</th>
                    <th>PHÒNG BAN</th>
                    <th>CẬP NHẬT</th>
                    <th>XÓA</th>
                  </tr>
                  </thead>
                  <tbody>
                    
                    <c:set var ="count" value="0" />
                    <c:forEach var="d" items="${list }">
                  
                    	<tr>
                    		<c:set var ="count" value="${count+1 }"/>
                    		<td>${count }</td>
                    		<td>${d[0] }</td>
                    		<td>${d[1] }</td>
                    		<td>${d[2] }</td>
                    		<td><a href="/QLNV/update${d[0]}"><button type="submit" name="btnUpdate" value="update" class="btn-hover color-2">SỬA</button></a></td>
                      		<td><a href="/QLNV/delete${d[0]}"><button type="submit" name="btnDelete" value="delete" class="btn-hover color-3">XÓA</button></a></td>           	
                    	
                      		        	
                    	</tr>
                  
                    </c:forEach>
                    
                    
                  </tbody>
              </table>
            </div>
    </body>