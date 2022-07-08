package FirmIT.Actions;

import FirmIT.Model.Employee;

import java.util.Comparator;

public class SorterByPayAndID implements Comparator <Employee> {
    @Override
    public int compare(Employee c1, Employee c2){
        if (c1.getSalary() == c2.getSalary()){
            return c1.getID() - c2.getID();
        }
        else {
        return (int)(c1.getSalary() - c2.getSalary());
        }
    }
}
