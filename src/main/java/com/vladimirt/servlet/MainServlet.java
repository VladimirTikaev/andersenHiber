package com.vladimirt.servlet;

import com.vladimirt.model.MyUser;
import com.vladimirt.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {


    private final static String PATCH = "/WEB-INF/jsp/main.jsp";
    private MyUserService service = new MyUserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MyUser> users = service.getAllUsers();
        req.setAttribute("usersList", users);
        resp.setContentType("text/html");

        req.getRequestDispatcher(PATCH).forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("user_id");
        if (id == null) {
            MyUser user = new MyUser();
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            service.createNewUser(user);
        } else {
            service.deleteUserById(id);
        }
        doGet(req, resp);

    }
}
