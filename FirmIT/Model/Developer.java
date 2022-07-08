package FirmIT.Model;

import FirmIT.Enum.Gender;
import FirmIT.Enum.Position;

public class Developer extends Employee {
    public Developer (int employeeID, String name, Position position, Gender gender, double salary){
        super (employeeID, name, position, gender, salary);

    }


}
