package Assignment2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        return name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        this.name = name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void raiseSalary(double byPercent){
        double raise = (byPercent/100) * salary;
        salary += raise;
    }
}

enum Gender {
    MALE,
    FEMALE;
}

public class Assignment2_1{
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        double ssTax;
        if(employee.salary<=8900){
            ssTax = 0.062*employee.salary;
        }
        else{
            ssTax = 0.062*106800;
        }
        return ssTax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        double insCoverage = 0;
        if(employee.age<35){
            insCoverage = 0.03 * employee.salary;
        }
        else if(employee.age>=35 && employee.age<=50){
            insCoverage = 0.04 * employee.salary;
        }
        else if(employee.age>=50 && employee.age<=60){
            insCoverage = 0.06 * employee.salary;
        }
        return insCoverage;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getSalary);
        list.sort(salaryComparator);
        for (Employee e : list){
            System.out.println(e.getName());
        }
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {

        employee.raiseSalary(200);
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     This is because java uses pass by value. So, whenever you pass something in a method, it takes the copy of those objects
     and the original objects remain unchanged.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

        Assignment2_1 obj = new Assignment2_1();
        double ssTax = obj.socialSecurityTax(a);
        System.out.println("\nSocial Security Tax for Jenny: "+ssTax);
        double insCoverage = obj.insuranceCoverage(a);
        System.out.println("Insurance Coverage for Jenny: "+insCoverage);

        Employee c = new Employee("Alice", 22, Gender.FEMALE, 500);
        System.out.println("\nEmployees sorted by salary:");
        obj.sortSalary(a,b,c);

        obj.tripleSalary(a);
        System.out.println("\nRaised Salary of Jenny: "+a.salary);


    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
