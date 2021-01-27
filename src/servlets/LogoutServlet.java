package servlets;


import acts.UserActs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    UserActs usersActs = UserActs.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String status = "";
        status = usersActs.logout(login);
        PrintWriter pw = resp.getWriter();
        if (status.equals("OK")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            pw.print(login + " exit");
            pw.close();
        } else {
            resp.setStatus(201);
            pw.print("error: " + status);
            pw.close();
        }

    }
}