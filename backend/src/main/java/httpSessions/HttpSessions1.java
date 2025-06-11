package httpSessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/httpsessions1")
public class HttpSessions1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("uname", username);
        session.setAttribute("email", email);
        session.setAttribute("password", password);

        out.println("<h1>Welcome "+username+"</h2>");
        out.println("<h1>session id "+session.getId()+"</h2>");
        out.println("<h1>creation time  "+session.getCreationTime()+"</h2>");
        out.println("<a href='"+ req.getContextPath()+"/httpsessions2'>Go to Http-Session-2 servlet</a>");

        out.close();


    }
}
