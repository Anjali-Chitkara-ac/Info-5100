package Assignment7;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HospitalRoom {

    private final AtomicInteger PATIENT_LIMIT = new AtomicInteger(3);
    private final AtomicInteger DOCTOR_LIMIT = new AtomicInteger(1);
    private final Set<Patient> patients;
    private final Set<Doctor> doctors;
    private final Object dObjectLock;
    private final Object pObjectLock;

    public HospitalRoom() {
        patients = new HashSet<>();
        doctors = new HashSet<>();
        dObjectLock = new Object();
        pObjectLock = new Object();
    }


    public boolean doctorEnter(Doctor d) throws InterruptedException {
        synchronized (dObjectLock){
            if(doctors.size() < DOCTOR_LIMIT.get()){
                doctors.add(d);
                System.out.println("Doctor " + d.name + " Entered, Number of Doctor " + doctors.size());
                dObjectLock.notify();
                return true;
            } else {
                System.out.println("Doctor " + d.name + " is waiting to Enter, Number of doctors " + doctors.size());
                dObjectLock.wait();
                return false;
            }
        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        synchronized (dObjectLock) {
            /*

             */
            if (doctors.size() < DOCTOR_LIMIT.get()) {
                dObjectLock.wait();
                return false;
            } else {
                doctors.remove(d);
                dObjectLock.notify();
                System.out.println("Doctor " + d.name + " left, Number of doctors " + doctors.size());
                return true;
            }
        }
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        synchronized (pObjectLock){
            /*

             */
            if (patients.size() < PATIENT_LIMIT.get()) {
                patients.add(p);
                System.out.println("Patient " + p.name + " Entered. Number of patients " + patients.size());
                pObjectLock.notify();
                return true;
            } else {
                System.out.println("Patient " + p.name + " is waiting to enter. number of patients " + patients.size());
                pObjectLock.wait();
                return false;
            }
        }
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        synchronized (pObjectLock){
            if(patients.size() == PATIENT_LIMIT.get()) {
                patients.remove(p);
                System.out.println("Patient " + p.name + " left the room.  Number of Patient " + patients.size());
                pObjectLock.notify();
                return true;
            } else {
                pObjectLock.wait();
                return false;
            }
        }
    }
}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {
                }
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();

    }
}
