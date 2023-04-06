package ma.bankati.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String page = """
        <!DOCTYPE html>
        <html>
        <head>
        <title>hello world</title>
        </head>
        <body>
        <h1>bonjour mes ami(e)s ^_^</h1>
        <h2>ceci est une page generee a partir de notre Servlet</h2>
        <ul>
        """;
        page += "<li> Protocol: " + request.getProtocol() + "</li>";
        page += "<li> Method: " + request.getMethod() + "</li>";
        page += "<li> Serveur: " + request.getServerName() + "</li>";
        page += "<li> Port: " + request.getServerPort() + "</li>";
        page += """
                </ul>
                </body>
                </html>
                """;



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(page);
        request.getRequestDispatcher("/secondController").forward(request, response);


}
}
