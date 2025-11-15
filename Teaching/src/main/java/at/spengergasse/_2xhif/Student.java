package at.spengergasse._2xhif;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Student {
    // Konstante - kann nicht mehr verändert werden (final) und gilt für alle Schüler (static)
    private static final int STUDENT_NUMBER_START = 1000;
    // statische Variable (gilt für alle Schüler)
    private static int studentNumberCounter = STUDENT_NUMBER_START;

    // konstante Membervariablen - existieren für ein Objekt (für einen Schüler)
    private final ZonedDateTime birthDay;
    private final String studentNumber;

    // Membervariablen - existieren für ein Objekt (für einen Schüler)
    private String firstname, lastname;

    public Student(String firstname, String lastname, ZonedDateTime birthDay) {
        this.birthDay = birthDay;
        this.firstname = firstname;
        this.lastname = lastname;

        {
            // lokale Variable - existieren nur in diesem Methoden-Scope
            // nextStudentNumber existiert nur innerhalb dieser Klammern ({})
            int nextStudentNumber = Student.studentNumberCounter++;
            studentNumber = lastname.substring(0, 3) + nextStudentNumber;
        }
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return studentNumber + ": " + firstname + " " + lastname + " " + birthDay;
    }

    public static void main(String[] args) {
        var studentA = new Student("Max", "Mustermann", ZonedDateTime.of(2010, 5, 23, 0, 0, 0, 0, ZoneId.systemDefault()));
        var studentB = new Student("Maxi", "Musterfrau", ZonedDateTime.of(2008, 8, 3, 0, 0, 0, 0, ZoneId.systemDefault()));

        System.out.println(studentA);
        System.out.println(studentB);
    }
}
