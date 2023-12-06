package QuanLyQuanNet.services;

import QuanLyQuanNet.models.Computer;
import QuanLyQuanNet.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class ManagerCustomer implements IManager<Customer> {
    List<Customer> customerList = new ArrayList<>();

    public ManagerCustomer() {
        customerList.add(new Customer(1,"hieu","hieu","1",12000));
    }

    @Override
    public void add(Customer add) {
        customerList.add(add);

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public void edit(int n, Customer customer) {
        int index = -1;
        for (int i = 0; i < this.customerList.size(); i++) {
            if (n == this.customerList.get(i).getId()) {
                index = i;
            }
        }
        customerList.set(index, customer);
    }

    @Override
    public void delete(int n) {
        customerList.removeIf(p -> p.getId() == n);
    }


    public Customer searchName(String name) {
        for (Customer p : customerList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Customer search(int n) {
        return null;
    }

    public Customer search2(String user, String pass) {
        for (Customer p : customerList) {
            if (p.getUserName().equals(user) && p.getPassWorld().equals(pass)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Computer> showAll() {
        for (Customer p : customerList) {
            System.out.println(p);
        }
        return null;
    }

}
