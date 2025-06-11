package urlRewritingServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/urlrewriting2")
public class UrlRewriting2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Details</h1>");
        out.println("<p>Email : " + email + " </p>");
        out.println("<p>Username : " + username + " </p>");
        out.println("<p>Password : " + password + " </p>");
        out.close();

    }
}
