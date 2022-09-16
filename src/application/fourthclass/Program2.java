package application.fourthclass;

import model.entities.fourthclass.Employee;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 public class Program2 {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        String path = "/Users/joaomarques/Desktop/InterfacesPractice/nameSalary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeCsv = br.readLine(); while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1]))); employeeCsv = br.readLine();
            }
            Collections.sort(list); for (Employee emp : list) {
                System.out.println(emp.getName() + ", " + emp.getSalary()); }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
















    /*public static void main(String[] args) throws Exception{

        List<Employee> employees = new ArrayList<>();

        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("/Users/joaomarques/Desktop/InterfacesPractice/nameSalary.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String name = sc.next();  //find and returns the next complete token from this scanner
            String salaryS = sc.next();
            double salary = Double.parseDouble(salaryS);

            Employee employee = new Employee(name, salary);
            employees.add(employee);
        }

        Collections.sort(employees);
        System.out.println(employees);

        sc.close();  //closes the scanner
    }*/