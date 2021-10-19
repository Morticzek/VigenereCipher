<%--
  Created by IntelliJ IDEA.
  User: Mortik
  Date: 02/01/2022
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Vigenere Cipher</title>
  </head>
  <body>
  <hr>
  <h1>Vigenere Cipher</h1>
  <hr>
  <form action="VigenereServlet" method="post">
    <p>Message: <input type="text" size="20" name="message"> </p>
    <p>Keyword: <input type="text" size="20" name="keyword"> </p>
    <p><input type="radio" name="operationType" value="encrypt" checked>Encryption </p>
    <p><input type="radio" name="operationType" value="decrypt">Decryption </p>
    <input type="submit" value="Send Request" />
  </form>
  <hr>
  </body>
</html>