package servlets;

import acts.UserActs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/reg")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserActs userActs = UserActs.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String status ="";
        status = userActs.registration(login, password);
        PrintWriter pw = resp.getWriter();

        if (status.equals("OK")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            pw.print("Registered");
        } else {
            resp.setStatus(201);
            pw.print("Error:" + status);
        }
    }
}



