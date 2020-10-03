package Assignment3;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Course a = new Course("english");
        System.out.println("Full? " + a.isFull());

        Student s1 = new Student("Jessi",101);
        Student s2 = new Student("James",102);
        Student s3 = new Student("Alice",103);
        Student s4 = new Student("Julie",104);
        Student s5 = new Student("Mary",105);
        Student s6 = new Student("Jane",106);
        Student s7 = new Student("Ana",107);
        Student s8 = new Student("John",108);
        Student s9 = new Student("Mike",109);
        Student s10 = new Student("Mili",110);
        Student s11 = new Student("Casper",111);

        a.registerStudent(s1);
        a.registerStudent(s2);
        a.registerStudent(s3);
        a.registerStudent(s4);
        a.registerStudent(s5);
        a.registerStudent(s6);

        System.out.println("Full? " +a.isFull());
        System.out.println("Course name: " + a.getName());
        System.out.println("Number of Students: " + a.getNumberOfStudents());

        a.registerStudent(s7);
        a.registerStudent(s8);
        a.registerStudent(s9);
        a.registerStudent(s10);

        System.out.println("Number of Students: " + a.getNumberOfStudents());
        Student[] enrolledStudents = a.getStudents();
        System.out.println(Arrays.toString(enrolledStudents));

        System.out.println("Full? " +a.isFull());

        a.registerStudent(s11);

        Professor p = new Professor.Builder("Cva","Dosapati",201)
                                    .setAddress("Western Avenue,Seattle")
                                    .setEmail("cva@gmail.com")
                                    .build();
        System.out.println(p);
    }
}
