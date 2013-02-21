<%-- 
    Document   : list
    Created on : Feb 21, 2013, 1:21:26 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar User</title>
    </head>
    <body>
        <h1>Daftar User</h1>
        
        <table border="0">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Role</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${daftarUser}">
                    <tr>
                        <td>${u.username}</td>
                        <td>${u.role.nama}</td>
                        <td>
                            <a href="form?id=${u.id}">edit</a> |
                            <a href="delete?id=${u.id}">hapus</a>
                        </td>
                    </tr>
                </c:forEach>
                
                
            </tbody>
        </table>

        
    </body>
</html>
