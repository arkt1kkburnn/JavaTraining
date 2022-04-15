package org.nikita.people;

import java.time.LocalDate;
import java.util.ArrayList;

public class Campus {
    public ArrayList<String> students = new ArrayList<>();

    public Campus() {
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }

    public void addStudentToCampus(String name1, String name2, String name3, int inn, LocalDate birthdate, LocalDate joindate){
        Student student = Student.getBuilder().
                setNames(name1,name2,name3).
                setInn(inn).
                setDates(birthdate,joindate).
                build();
        students.add(student.toString());
    }

    @Override
    public String toString() {
        return "Campus{" +
                "students=" + students +
                '}';
    }
}
