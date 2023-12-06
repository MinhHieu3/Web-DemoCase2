package QuanLyQuanNet.controller;

import QuanLyQuanNet.models.Computer;
import QuanLyQuanNet.services.ManagerComputer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "computerServlet", value = "/abc")

public class HomeComputer extends HttpServlet {
    ManagerComputer managerComputer = new ManagerComputer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showListCreate(req, resp);
                break;
            case "edit":
                showListEdit(req, resp);
                break;
            case "delete":
                showListDelete(req, resp);
                break;
            default:
                showListComputer(req, resp);
        }
    }

    private void showListDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        managerComputer.delete(id);
        resp.sendRedirect("/abc");


    }

    private void showListEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerComputer/editComputer.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Computer computer = managerComputer.search(id);
        req.setAttribute("sua", computer);
        requestDispatcher.forward(req, resp);
    }

    private void showListCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerComputer/createComputer.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showListComputer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerComputer/listComputer.jsp");
        List<Computer> list = managerComputer.getComputerList();
        req.setAttribute("danhSachComputer", list);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;

        }
    }


    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        managerComputer.edit(id, new Computer(id, price));
        resp.sendRedirect("/abc");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        managerComputer.add(new Computer(id, price));
        resp.sendRedirect("/abc");
    }
}
