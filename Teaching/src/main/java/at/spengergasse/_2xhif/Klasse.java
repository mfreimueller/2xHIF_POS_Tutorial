package at.spengergasse._2xhif;

import java.util.*;
import java.time.*;

public class Klasse
{
    private HashMap<String, Student> students;
    
    public Klasse() {
        students = new HashMap<>();
    }
    
    public void addStudent(Student student) {
        // TODO: if null...
        
        students.put(student.getStudentNumber(), student);
    }
    
    public Student getStudent(String studentNumber) {
        // TODO: if null...
        
        if (!students.containsKey(studentNumber)) {
            throw new IllegalArgumentException("studentNumber doesn't exist!");
        }
        
        // students.remove(student)
        
        return students.get(studentNumber);
    }
    
    public static void main(String[] args) {
        Student studentA = new Student("Max", "Mustermann", ZonedDateTime.of(2010, 5, 23, 0, 0, 0, 0, ZoneId.systemDefault()));
        Student studentB = new Student("Maxi", "Musterfrau", ZonedDateTime.of(2008, 8, 3, 0, 0, 0, 0, ZoneId.systemDefault()));

        Klasse klasse = new Klasse();
        klasse.addStudent(studentA);
        klasse.addStudent(studentB);

        // fails, because "abc" is no key of klasse
        // Student found = klasse.getStudent("abc");
        
        Student found = klasse.getStudent(studentA.getStudentNumber());
    }
}