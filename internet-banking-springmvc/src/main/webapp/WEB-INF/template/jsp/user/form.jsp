<%-- 
    Document   : form
    Created on : Feb 21, 2013, 2:31:21 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
    </head>
    <body>
        <h1>Edit User</h1>

        <form method="post">

            <table border="0">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input name="username" type="text"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input name="password" type="password"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td><input name="role.id" type="text"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Simpan"/></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>

    </body>
</html>
