package dev.morticzek.servlets;

import dev.morticzek.model.VigenereModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Encryption")
public class VigenereServletEncryption extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-2");
        String message = request.getParameter("message");
        String keyword = request.getParameter("keyword");
        PrintWriter writer = response.getWriter();

        VigenereModel vigenereModel = new VigenereModel(message, keyword, true, false);
        vigenereModel.vigenereEncryption(message, keyword);

        writer.println(
            "<html>\n" +
                "<body>\n" +
                    "<h3>Message: " + vigenereModel.getMessage() + "</h3>\n" +
                    "<h3>Keyword: " + vigenereModel.getKeyword() + "</h3>\n" +
                    "<h3>Encryption result: " + vigenereModel.getEncryptedMessage() + "</h3>\n" +
                "</body>\n" +
            "</html>"
        );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-2");
        String message = request.getParameter("message");
        String keyword = request.getParameter("keyword");
        PrintWriter writer = response.getWriter();

        VigenereModel vigenereModel = new VigenereModel(message, keyword, true, false);
        vigenereModel.vigenereEncryption(message, keyword);

        writer.println(
            "<html>\n" +
                "<body>\n" +
                    "<h3>Message: " + vigenereModel.getMessage() + "</h3>\n" +
                    "<h3>Keyword: " + vigenereModel.getKeyword() + "</h3>\n" +
                    "<h3>Encryption result: " + vigenereModel.getEncryptedMessage() + "</h3>\n" +
                "</body>\n" +
            "</html>"
        );
    }
}
