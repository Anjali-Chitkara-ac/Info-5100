package Assignment8;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    private String fName;
    private String lName;
    private String password;
    private String department;
    private String altEmail;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.fName = firstName;
        this.lName = lastName;
    }

    // Ask for the department
    private String SetDepartment() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER DEPARTMENT CODE BELOW");
        System.out.println("1 for Sales\n" +
                            "2 for Development\n" +
                            "3 for Accounting\n" +
                            "0 for none");
        int departmentCode = scanner.nextInt();
        if(departmentCode==1){
            this.department = "sales";
        }
        else if(departmentCode==2){
            this.department = "dev";
        }
        else if(departmentCode==3){
            this.department = "acc";
        }
        else if(departmentCode==0){
            this.department = "none";
        }
        else {
            throw new IOException("Invalid input. Please re-run the program and enter a valid option");
        }
        return this.department;
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < length; i ++) {
            password.append(passwordSet.charAt(random.nextInt(40)));
        }
        this.password = password.toString();
        return password.toString();
    }

    //set method to change the password
    public void changePassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NEW PASSWORD BELOW");
        this.password = scanner.nextLine();
    }

    public String getDepartment(){
        return this.department;
    }

    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set - define alt email address
    public void setAltEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER YOUR ALTERNATE EMAIL ADDRESS BELOW: ");
        String altEmail = scanner.nextLine();
        this.altEmail = altEmail;

    }

    //get method to display name
    public String getName(){
        return fName + " " + lName;
    }

    //get method to display mailbox capacity
    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }

    //get method for email
    public String getCompanyEmail(){
        String dept = getDepartment();
        if(dept.equals("none")){
            return fName + "." + lName + "@" + companySuffix;
        }
        return fName + "." + lName + "@" + getDepartment() + "." + companySuffix;
    }

    public void showInfo() throws IOException {
        System.out.println("NEW WORKER: " + getName());
        Email em = new Email("anjali", "c");
        SetDepartment();
        randomPassword(defaultPasswordLength);

        System.out.println("DISPLAY NAME: " + getName());
        System.out.println("DEPARTMENT: " + getDepartment());
        System.out.println("COMPANY EMAIL: " + getCompanyEmail());
        System.out.println("PASSWORD: " + password);
        System.out.println("MAILBOX CAPACITY: " + getMailboxCapacity() + "mb");

    }

//    public static void main(String[] args) throws IOException {
//        Email nm = new Email("anjali", "c");
//        nm.showInfo();
//    }


}
