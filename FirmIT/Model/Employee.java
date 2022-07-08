package FirmIT.Model;

import FirmIT.Enum.Gender;
import FirmIT.Enum.Position;

public abstract class Employee implements Comparable <Employee>{

    private int employeeID;
    private String name;
    private Gender gender;
    private Position position;
    private double salary;

   public Employee (int employeeID, String name, Position position, Gender gender, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
    }

    public double salaryRaise(double Percent){
       double salaryRaise = salary * Percent/100;
       salary += salaryRaise;
       return salary;
    }
    public String getName (){
        return name;
    }

    public int getID (){
        return employeeID;
    }

    public double getSalary (){
        return salary;
    }

    public Position getPosition (){return position;}


    @Override
    public String toString(){
       return "ID: " + getID() + "\nName: " +getName() + "\nPosition: " + position + "\nSalary per hour: " + getSalary() + "\nGender: " + gender
               + "\n";
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.getID() - o.getID();
        if (result == 0) {
            result = this.getName().compareTo(o.getName());
        }
        return result;
    }

    }

