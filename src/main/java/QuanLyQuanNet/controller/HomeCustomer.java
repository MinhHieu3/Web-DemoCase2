package QuanLyQuanNet.controller;

import QuanLyQuanNet.models.Computer;
import QuanLyQuanNet.models.Customer;
import QuanLyQuanNet.services.ManagerCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customers")
public class HomeCustomer extends HttpServlet {
    ManagerCustomer managerCustomer=new ManagerCustomer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            default:
                showListForm(req,resp);
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        managerCustomer.delete(id);
        resp.sendRedirect("/customers");

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("managerCustomer/edit.jsp");
        int id= Integer.parseInt(req.getParameter("id"));
        Customer customer=managerCustomer.search(id);
        req.setAttribute("sua",customer);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                Create(req,resp);
                break;
            case "edit":
                Edit(req,resp);
                break;
        }
    }

    private void Edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");
        double money= Double.parseDouble(req.getParameter("money"));
        managerCustomer.edit(id,new Customer(id,name,user,pass,money));
        resp.sendRedirect("/customers");

    }

    private void Create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");
        double money= Double.parseDouble(req.getParameter("money"));
        managerCustomer.add(new Customer(id,name,user,pass,money));
        resp.sendRedirect("/customers");

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("managerCustomer/create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showListForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerCustomer/listCustomer.jsp");
        List<Customer> list = managerCustomer.getCustomerList();
        req.setAttribute("danhSachCustomer", list);
        requestDispatcher.forward(req, resp);
    }

}
