package QuanLyQuanNet.services;

import QuanLyQuanNet.models.Computer;

import java.util.ArrayList;
import java.util.List;

public class ManagerComputer implements IManager<Computer> {
    List<Computer> computerList = new ArrayList<>();

    public ManagerComputer() {
        computerList.add(new Computer(1,1200));
        computerList.add(new Computer(2,1300));
    }


    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public void add(Computer computer) {

        computerList.add(computer);
    }

    @Override
    public void edit(int n, Computer computer) {
        int index = -1;
        for (int i = 0; i < this.computerList.size(); i++) {
            if (n == this.computerList.get(i).getId()) {
                index = i;
            }
        }
        computerList.set(index, computer);
    }

    @Override
    public void delete(int n) {
        computerList.removeIf(p -> p.getId() == n);
    }

    @Override
    public Computer search(int n) {
        for (Computer p : computerList) {
            if (p.getId() == n) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Computer> showAll() {
        for (Computer p : computerList) {
            System.out.println(p);
        }
        return null;
    }

}
