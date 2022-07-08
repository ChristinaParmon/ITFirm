package FirmIT.Model;

import FirmIT.Enum.Gender;
import FirmIT.Enum.Position;
import FirmIT.Model.Employee;

public class Manager extends Employee {
    private double bonus;
    public Manager (int employeeID, String name, Position position, Gender gender, double salary){
        super (employeeID, name, position, gender, salary);
        bonus = 0;
    }



    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString(){
        return super.toString() + "Bonus: " + bonus + "\n" ;
    }
}
