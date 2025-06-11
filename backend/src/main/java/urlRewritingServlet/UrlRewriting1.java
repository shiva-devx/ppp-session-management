package urlRewritingServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/urlrewriting1")
public class UrlRewriting1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your details have been submitted</h1>");
        out.println("<a href='./urlrewriting2?username=" + username + "&password=" + password + "&email=" + email + "'> click here to see details </a>");

        out.close();

    }
}
