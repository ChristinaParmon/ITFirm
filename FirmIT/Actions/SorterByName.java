package FirmIT.Actions;

import FirmIT.Model.Employee;

import java.util.Comparator;

public class SorterByName implements Comparator<Employee> {
    @Override
    public int compare(Employee c1, Employee c2){

            return c1.getName().compareTo(c2.getName()) ;

    }
}

