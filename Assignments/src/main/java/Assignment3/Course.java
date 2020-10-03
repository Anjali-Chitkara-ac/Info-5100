package Assignment3;

import java.util.*;

public class Course {
    private String name;
    private int numberOfStudents;
    private Student[] registeredStudents;

    public Course(String name){
        this.name = name;
        registeredStudents = new Student[10];
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        int i=0;
        while (i<registeredStudents.length && registeredStudents[i]!=null){
            i++;
        }
        numberOfStudents = i;
        return numberOfStudents;
    }

    public void registerStudent(Student s){
        if(!isFull()) {
            int i=0;
            while (registeredStudents[i]!=null){
                i++;
            }
            registeredStudents[i]=s;
        }else{
            System.out.println("Seats full.Cannot Add More Students!");
        }
    }

    public Student[] getStudents(){
        return this.registeredStudents;
    }

    public boolean isFull(){
        if(registeredStudents[9]!=null){
            return true;
        }else return false;
    }
}
