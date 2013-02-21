<%-- 
    Document   : form
    Created on : Feb 21, 2013, 2:31:21 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
    </head>
    <body>
        <h1>Edit User</h1>

        <spring:form modelAttribute="user">

            <table border="0">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td>
                            <spring:input path="username"/>
                        </td>
                        <td>
                            <font color="red">
                                <spring:errors path="username"/>
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><spring:password path="password"/></td>
                        <td>
                            <font color="red">
                                <spring:errors path="password"/>
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td><spring:input path="role.id"/></td>
                        <td>
                            <font color="red">
                                <spring:errors path="role"/>
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Simpan"/></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </spring:form>

    </body>
</html>
