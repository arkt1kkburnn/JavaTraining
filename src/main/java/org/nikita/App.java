package org.nikita;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nikita.people.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        json json = new JsonImpl();
        Campus campus = new Campus();
        campus.addStudentToCampus("Nikita", "Igorevich", "Sharov",1234567,LocalDate.of(2002, 4, 5),
                LocalDate.of(2021, 5, 5));
        campus.addStudentToCampus("Polina", "Denisovna", "Lipnitskaya",1234567,LocalDate.of(2002, 4, 5),
                LocalDate.of(2021, 5, 5));
        json.jwrite("C:/Users/Я/IdeaProjects/MyUniversity1/src/Student.json",campus);
        new Jframe();
    }
}

