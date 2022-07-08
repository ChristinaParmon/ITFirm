package FirmIT.Interfaces;

import FirmIT.Model.Employee;

import java.util.ArrayList;

public  interface TeamOperations {
    public double paymentToAll(ArrayList<Employee> list, double sum);

    public String finalAmount (double paymentToAll, double budget);

    public StringBuilder getEmployeeBySalary (double min, double max, ArrayList <Employee> list);

}

