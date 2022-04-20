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
        Starter.start();
        new Jframe();
    }
}

