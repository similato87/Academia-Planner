package Controller;

import Model.Enrollment;

import java.util.Scanner;

public class EnrollmentProxy extends Enrollment {
    private final String password;
    private Enrollment enrollment;

    public EnrollmentProxy(String password) {
        this.password = password;
    }

    private void authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter password:");
        String input = scanner.nextLine();
        if (!input.equals(password)) {
            throw new SecurityException("Incorrect password");
        }
        if (enrollment == null) {
            enrollment = new Enrollment();
        }
    }
    public void editEnrollment() {
        authenticate();
        //todo: enrollmentsetter

    }


}