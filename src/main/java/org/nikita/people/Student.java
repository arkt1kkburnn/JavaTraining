package org.nikita.people;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nikita.App;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Student implements Comparable<Student> {

    protected StudentName name;
    protected int inn;
    protected LocalDate birthDate;
    protected LocalDate joinDate;




        protected class StudentName {
            private String myName;
            private String famName;
            private String fathName;

            public StudentName(String myName, String famName, String fathName) {
                setMyName(myName);
                setFamName(famName);
                setFathName(fathName);
            }

            public String getMyName() {
                return myName;
            }

            public String getFamName() {
                return famName;
            }

            public String getFathName() {
                return fathName;
            }

            public void setMyName(String myName) {
                if (myName == null) return;
                if (!Character.isUpperCase(myName.charAt(0))) myName = "";
                if (!myName.matches("[a-zA-Z]+")) myName = "";
                this.myName = myName;
            }

            public void setFamName(String famName) {
                if (famName == null) return;
                if (!Character.isUpperCase(famName.charAt(0))) famName = "";
                if (!famName.matches("[a-zA-Z]+")) famName = "";
                this.famName = famName;
            }

            public void setFathName(String fathName) {
                if (fathName == null) return;
                if (!Character.isUpperCase(fathName.charAt(0))) fathName = "";
                if (!fathName.matches("[a-zA-Z]+")) fathName = "";
                this.fathName = fathName;
            }

            @Override
            public String toString() {
                return (myName + ' ' +
                        famName + ' ' +
                        fathName).trim();
            }


            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null) return false;
                if (this.getClass() != object.getClass()) return false;
                StudentName obj = (StudentName) object;
                return Objects.equals(this.myName, obj.myName) && Objects.equals(this.famName, obj.famName) && Objects.equals(this.fathName, obj.fathName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(myName, famName, fathName);
            }
        }


        public static class Builder implements Validator {
            private String name1;
            private String name2;
            private String name3;
            private int inn;
            private LocalDate birthDate;
            private LocalDate joinDate;


            public Builder setNames(String name1, String name2, String name3) {
                this.name1 = name1;
                this.name2 = name2;
                this.name3 = name3;
                return this;
            }

            public boolean valid(int id) {
                int sum = 0;
                int count = 0;
                while (id != 0) {
                    int temp = id % 10;
                    id /= 10;
                    sum += temp;
                    count++;
                }
                return count == 7 && sum % 2 == 0;
            }

            public Builder setInn(int id) {
                if (valid(id)) {
                    this.inn = id;
                    return this;
                } else throw new IllegalArgumentException(
                        String.format("entered inn:%d is invalid",
                                id));
            }

            public Builder setDates(LocalDate d1, LocalDate d2) {
                birthDate = d1;
                joinDate = d2;
                return this;
            }

            public Student build() {
                var r = new Student();
                r.setName(this.name1, this.name2, this.name3);
                r.setInn(this.inn);
                r.setBirthDate(this.birthDate);
                r.setJoinDate(this.joinDate);
                return r;
            }

            private Builder() {
            }
        }


        public String getName () {
            return name.toString();
        }

        public void setName (String name1, String name2, String name3){
            this.name = new StudentName(name1, name2, name3);
        }

        public int getInn () {
            return inn;
        }

        public void setInn ( int inn){
            this.inn = inn;
        }

        public LocalDate getBirthDate () {
            return birthDate;
        }

        public void setBirthDate (LocalDate birthDate){
            this.birthDate = birthDate;
        }

        public LocalDate getJoinDate () {
            return joinDate;
        }

        public void setJoinDate (LocalDate joinDate){
            this.joinDate = joinDate;
        }

        public static Builder getBuilder () {
            return new Builder();
        }

    protected Student() {
        }

        @Override
        public String toString () {
            return (name.toString() + ' ' +
                    inn + ' ' +
                    birthDate + ' ' +
                    joinDate).trim();
        }

        @Override
        public boolean equals (Object object){
            if (this == object) return true;
            if (object == null) return false;
            if (this.getClass() != object.getClass()) return false;
            Student obj = (Student) object;
            return obj.name.equals(this.name) && obj.inn == this.inn && this.joinDate.equals(obj.joinDate) && this.birthDate.equals(obj.birthDate) &&
                    hashCode() == Objects.hash(obj.name, obj.inn, obj.birthDate, obj.joinDate);
        }

        @Override
        public int hashCode () {
            return Objects.hash(name, inn, birthDate, joinDate);
        }

        public int compareTo (Student student){
            if (student.joinDate.compareTo(this.joinDate) != 0) return student.joinDate.compareTo(this.joinDate);
            return student.birthDate.compareTo(this.birthDate);
        }


    }





