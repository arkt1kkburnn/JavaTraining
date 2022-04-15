package org.nikita;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nikita.people.Student;

import java.io.File;
import java.time.LocalDate;
import java.util.Objects;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true, "Специально завалили");
    }

    @Test
    public void studentGoodNameTest() {
        Student student = Student.getBuilder().build();
        student.setName("Nikita", "Igorevich", "Sharov");
        var s = student.getName();
        assertEquals(s, "Nikita Igorevich Sharov", "Имя без ошибок");
    }

    @Test
    public void studentBadNameTest() {
        Student student = Student.getBuilder().
                setNames("nikita", "$Igorevich", "Sharov@").
                setInn(1234567).
                setDates(LocalDate.of(2002, 5, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        var s = student.getName();
        assertEquals(s, "", "Имя c ошибками");
    }


    @Test
    public void studentToString() {
        Student student = Student.getBuilder().
                setNames("Nikita", "Igorevich", "Sharov").
                setInn(1234567).
                setDates(LocalDate.of(2002, 5, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        var s = student.toString();
        assertEquals(s, "Nikita Igorevich Sharov 1234567 2002-05-05 2021-05-05");
    }

    @Test
    public void compareTwoStudents() {
        Student student1 = Student.getBuilder().
                setNames("Nikita", "Igorevich", "Sharov").
                setInn(1234567).
                setDates(LocalDate.of(2002, 5, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        Student student2 = Student.getBuilder().
                setNames("Polina", "Denisovna", "Lipnitskaya").
                setInn(1234567).
                setDates(LocalDate.of(2002, 4, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        var s = student1.compareTo(student2);
        assertEquals(s, -1);
    }


    @Test
    public void equals() {
        Student student1 = Student.getBuilder().
                setNames("Nikita", "Igorevich", "Sharov").
                setInn(1234567).
                setDates(LocalDate.of(2002, 5, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        Student student2 = Student.getBuilder().
                setNames("Nikita", "Igorevich", "Sharov").
                setInn(1234567).
                setDates(LocalDate.of(2002, 5, 5),
                        LocalDate.of(2021, 5, 5)).
                build();
        var s = student1.equals(student2);
        assertTrue(s);
    }

}
