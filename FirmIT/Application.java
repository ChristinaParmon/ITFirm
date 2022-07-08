package FirmIT;

import FirmIT.Actions.SorterByPayAndID;
import FirmIT.Actions.SorterByName;
import FirmIT.Enum.Gender;
import FirmIT.Enum.Position;
import FirmIT.FileConvertor.Convertor;
import FirmIT.Model.Developer;
import FirmIT.Model.Employee;
import FirmIT.Model.Manager;
import FirmIT.Model.Tester;
import org.json.simple.JSONObject;

import java.util.Scanner;


import java.util.ArrayList;

import static FirmIT.FileConvertor.Convertor.readJsonSimpleDemo;
import static FirmIT.FileConvertor.Convertor.writeJsonSimpleDemo;

public class Application{
    public void run() {
        try {
            Scanner in = new Scanner(System.in);

            ArrayList<Employee> team = new ArrayList<Employee>() {
                {
                    add(new Developer(3, "Liza Ivanova", Position.DEVELOPER, Gender.FEMALE, 50));
                    add(new Manager(2, "Nastya Vishneva", Position.MANAGER, Gender.FEMALE, 45));
                    add(new Tester(1, "Angelina Sivakova", Position.TESTER, Gender.NONBINARY, 15));
                    add (new Developer(4, "Vincent Tanyan", Position.DEVELOPER, Gender.MALE, 50));
                    add(new Developer(5, "Melissa Evans",Position.DEVELOPER, Gender.NONBINARY, 45));
                }
            };


            System.out.println("-------до сортировки--------");
            for (Employee str : team) {
                System.out.println(str.toString());
            }

            System.out.println("-------после сортировки по имени-----");
            SorterByName findTwo = new SorterByName();
            team.sort(findTwo);
            for (Employee str : team) {
                System.out.println(str.toString());
            }

            System.out.println("-------после сортировки по зарплате, если она равна то по ID-----");
            SorterByPayAndID find = new SorterByPayAndID();
            team.sort(find);
            for (Employee str : team) {
                System.out.println(str.toString());
            }



            System.out.println("Введите ваш общий бюджет ($): ");


            double budget = in.nextDouble();
            System.out.format(finalAmount(paymentToAll(team, 0), budget));

            System.out.println("\nВведите минимум, который вы готовы платить одному рабочему за час работы: ");
            double min = in.nextDouble();

            System.out.println("\nВведите максимум, который вы готовы платить одному рабочему за час работы: ");
            double max = in.nextDouble();

            StringBuilder item = getEmployeeBySalary(min, max, team);
            System.out.println("\nСотрудники, которых вы можете нанять: " + item);

            Convertor.exportToTXTFile("Export", team);

            writeJsonSimpleDemo("example.json");

            JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("example.json");
            System.out.println(jsonObject);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }




    public double paymentToAll(ArrayList<Employee> team, double sum) {

        for (Employee str : team) {
            sum += str.getSalary();
        }
        return sum;
    }

    public StringBuilder getEmployeeBySalary (double min, double max, ArrayList <Employee> list){
        StringBuilder employee = new StringBuilder();
        for (Employee str : list) {
            if ((str.getSalary() >= min && str.getSalary() <= max) ) {
                employee.append(str.getName()).append("(").append(str.getID()).append(")").append("(").append(str.getPosition()).append("), ");
            }
        }
        if (min < 0 || max < 0) {

            throw new IllegalArgumentException("Данные не могут быть ниже нуля");
        }
        return employee;
    }


    public String finalAmount (double paymentToAll, double budget)
    {

        if (paymentToAll > budget){
            return  "Введенной вами суммы не хватит на проект";

        }
        else {
            double finalAmount = budget/paymentToAll;
            return "Введенной вами суммы хватит на " + String.format("%.2f",finalAmount) + " часов работы.";
        }
    };


}
