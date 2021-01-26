package servlets;

import acts.UserActs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    UserActs usersActs = UserActs.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    String status ="";
    status = usersActs.login(login, password);
    PrintWriter pw = resp.getWriter();
        if (status.equals("OK")) {
        resp.setStatus(HttpServletResponse.SC_OK);
        pw.print(login + " enter" );
    } else {
        resp.setStatus(201);
        pw.print("error: " + status);
    }

}
}

