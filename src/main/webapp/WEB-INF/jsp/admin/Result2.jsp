<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>
    	<div id = "bar2" class ="title-bar">
              <p>THỐNG KÊ THEO NHÂN VIÊN</p>
            </div>
             
            <div class="table">
              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>PHÒNG BAN</th>
                    <th>KHEN THƯỞNG</th>
                    <th>KỶ LUẬT</th>
                    <th>TỔNG KẾT</th>
                  </tr>
                  </thead>
                  <tbody>
                    
                    <c:set var ="count" value="0" />
                    <c:forEach var="d" items="${array }">
                  
                    	<tr>
                    		<c:set var ="count" value="${count+1 }"/>
                    		<td>${count }</td>
                    		
                    		<td>${d[1] }</td>
                    		<td>${d[2] }</td>
                    		<td>${d[3] }</td>
                    		<td>${d[2] - d[3] }</td>
                    		
                      		        	
                    	</tr>
                  
                    </c:forEach>
                    
                    
                  </tbody>
              </table>
            </div>
    </body>