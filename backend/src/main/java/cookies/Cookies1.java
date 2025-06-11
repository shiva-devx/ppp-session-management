package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie1")
public class Cookies1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password");

        Cookie nameCookie = new Cookie("user_name", username);

        resp.addCookie(nameCookie);

        Cookie emailCookie = new Cookie("email", email);
        resp.addCookie(emailCookie);
        resp.addCookie(new Cookie("password", password));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Your details have been submitted - using cookies</h1>");

//        MOST IMPORTANT -> Links (<a href="...") always send GET requests.
        out.println("<a href='"+ req.getContextPath()+"/cookie2' >Click here to see details</a>");
        out.close();


    }
}
