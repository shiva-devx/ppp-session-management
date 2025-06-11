package httpSessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/httpsessions2")
public class HttpSessions2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // use previous session
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("uname");
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        out.println("<h1> Hello, welcome back "
                + username + " </h1>");
        out.println("<h2>Email : "+email+"</h2>");
        out.println("<h2>password : "+password+"</h2>");
        out.println("<h2>Thank you!!</h2>");
        out.println("<p>this servlet is using sessions</p>");

        out.close();

    }
}
