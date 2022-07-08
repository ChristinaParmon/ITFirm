package FirmIT.Model;

import FirmIT.Enum.Gender;
import FirmIT.Enum.Position;
import FirmIT.Model.Employee;

public class Tester extends Employee {
    public Tester (int employeeID, String name, Position position, Gender gender, double salary){
        super (employeeID, name, position, gender, salary);
    }
}
