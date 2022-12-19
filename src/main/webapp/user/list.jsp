<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/heading.jsp" %>
    <style>
        th, td { text-align: center; }
    </style>
</head>

<body>
    <%@ include file="../common/top.jsp" %>

    <div class="container" style="margin-top: 80px;">
        <div class="row">
            <%@ include file="../common/aside.jsp" %>
            
            <!-- =================== main =================== -->
            <div class="col-sm-9">
            	<h3><strong>사용자 목록</strong></h3>
            	<hr>
                <div class="row">
					<div class="col-1"></div>
			        <div class="col-11">
			            <table class="table table-condensed table-hover" style="margin-bottom: 80px;">
			                <tr class="table-secondary d-flex">
			                    <th class="col-1">번호</th>
			                    <th class="col-2">uid</th>
			                    <th class="col-2">이름</th>
			                    <th class="col-4">이메일</th>
			                    <th class="col-2">가입일</th>
			                    <th class="col-1">액션</th>
			                </tr>   
			                <tr class="d-flex">
		                        <td class="col-1">1</td>
		                        <td class="col-2">koandjo</td>
		                        <td class="col-2">고예림</td>
		                        <td class="col-4">koandjo9116@gmail.com</td>
		                        <td class="col-2">2022-10-27</td>
		                        <td class="col-1">
		                            <a href="/user/update/koandjo"><i class="fas fa-user-edit"></i></a>
		                            <a href="/user/delete/koandjo"><i class="fas fa-user-minus"></i></a>
		                        </td>
                   			</tr> 
                   		</table>            
	                </div>
            </div>
            <!-- =================== main =================== -->
            
        </div>
    </div>

    <%@ include file="../common/bottom.jsp" %>
</body>
</html>