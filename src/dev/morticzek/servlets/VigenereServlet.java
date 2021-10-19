package dev.morticzek.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * VigenereServlet is a public class acting as an HTTP servlet responsible for Vigenere Cipher web application.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */
@WebServlet("/VigenereServlet")
public class VigenereServlet extends HttpServlet {
    /**
     * Method handling HTTP <code>POST</code> method
     * @param request Servlet request
     * @param response Servlet response
     * @throws IOException When an error associated with I/O arises
     * @throws ServletException When an error associated with Servlets arises
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter writer = response.getWriter();
        String operationType = request.getParameter("operationType");

        if(operationType.equals("encrypt"))
        {
            getServletContext().getRequestDispatcher("/Encryption").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/Decryption").forward(request, response);
        }

//        writer.println(
//                "<html>\n" +
//                    "<body>\n" +
//                        "<h3>Message: " + vigenereModel.getMessage() + "</h3>\n" +
//                        "<h3>Keyword: " + vigenereModel.getKeyword() + "</h3>\n" +
//                        "<h3>Encryption result: " + vigenereModel.getEncryptedMessage() + "</h3>\n" +
//                        "<h3>Decryption result: " + vigenereModel.getDecryptedMessage() + "</h3>\n" +
//                    "</body>\n" +
//                "</html>"
//        );
    }
    /**
     * Method handling HTTP <code>GET</code> method
     * @param request Servlet request
     * @param response Servlet response
     * @throws IOException When an error associated with I/O arises
     * @throws ServletException When an error associated with Servlets arises
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html; charset=ISO-8859-2");
        String message = request.getParameter("message");
        String keyword = request.getParameter("keyword");
        String operationType = request.getParameter("operationType");

        if(operationType.equals("encrypt"))
        {
            getServletContext().getRequestDispatcher("/Encryption").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/Decryption").forward(request, response);
        }

//        writer.println(
//                "<html>\n" +
//                        "<body>\n" +
//                        "<h3>Message: " + vigenereModel.getMessage() + "</h3>\n" +
//                        "<h3>Keyword: " + vigenereModel.getKeyword() + "</h3>\n" +
//                        "<h3>Encryption result: " + vigenereModel.getEncryptedMessage() + "</h3>\n" +
//                        "<h3>Decryption result: " + vigenereModel.getDecryptedMessage() + "</h3>\n" +
//                        "</body>\n" +
//                        "</html>"
//        );
    }
}
