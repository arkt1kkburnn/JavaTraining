package org.nikita.people;

import java.time.LocalDate;

public class Starter {
    public static void start(){
        json json = new JsonImpl();
        Campus campus = new Campus();
        campus.addStudentToCampus("Nikita", "Igorevich", "Sharov",1234567, LocalDate.of(2002, 4, 5),
                LocalDate.of(2021, 5, 5));
        campus.addStudentToCampus("Polina", "Denisovna", "Lipnitskaya",1234567,LocalDate.of(2002, 4, 5),
                LocalDate.of(2021, 5, 5));
        json.jwrite("C:/Users/Я/IdeaProjects/MyUniversity1/src/Student.json",campus);
    }
}
