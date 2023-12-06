package QuanLyQuanNet.controller;

import QuanLyQuanNet.models.Computer;
import QuanLyQuanNet.models.Product;
import QuanLyQuanNet.services.ManagerProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products")
public class ProductController extends HttpServlet {
    ManagerProduct managerProduct=new ManagerProduct();

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
        managerProduct.delete(id);
        resp.sendRedirect("/products");
    }

    private void showListEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerProduct/edit.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product =managerProduct.search(id);
        req.setAttribute("sua",product);
        requestDispatcher.forward(req, resp);
    }

    private void showListCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerProduct/create.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showListComputer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("managerProduct/listProduct.jsp");
        List<Product> list = managerProduct.getProductList();
        req.setAttribute("danhSachProduct", list);
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
        int id= Integer.parseInt(req.getParameter("id"));
        String name =req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        managerProduct.edit(id,new Product(id,name,price,quantity));
        resp.sendRedirect("/products");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name =req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        managerProduct.add(new Product(id,name,price,quantity));
        resp.sendRedirect("/products");
    }
}


