package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie2")
public class Cookies2 extends HttpServlet {
    @Override
//    method is doGet instead of doPost because we came here by <a> -> which always send get request
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        boolean isOldUser = false;
        String username = "";
        String email = "";
        String password = "";

        if(cookies == null){
            out.println(
                    "<h1>You are new user, go to home page and submit your institute's name");
            return;
        } else{
            for(Cookie cookie : cookies){
                String cookieName = cookie.getName();
                isOldUser = true;
                switch (cookieName){
                    case "user_name" -> username = cookie.getValue();
                    case "email" -> email = cookie.getValue();
                    case "password" -> password = cookie.getValue();
                    default -> {
                        username = null;
                        email = null;
                        password = null;
                    }
                }
            }
        }

        if(isOldUser){
            out.println("<h1> Hello, welcome back "
                    + username + " </h1>");
            out.println("<h2>Email : "+email+"</h2>");
            out.println("<h2>password : "+password+"</h2>");
            out.println("<h2>Thank you!!</h2>");
        }

        out.close();
    }
}
