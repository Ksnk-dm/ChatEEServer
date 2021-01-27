package servlets;

import acts.UserActs;
import utils.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "allusers", value = "/alluser")

public class AllUsersServlet extends HttpServlet {
    UserActs userActs = UserActs.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String users = userActs.allUsers();
        PrintWriter pw = resp.getWriter();
        pw.print("all users:" + users);
        pw.close();

    }
}
