package org.nikita.people;

import java.time.LocalDate;

public class HeadStudent extends Student {
    public LocalDate dateOfElection;

    public HeadStudent(LocalDate dateOfElection) {
        this.dateOfElection = dateOfElection;
    }

    public LocalDate getDateOfElection() {
        return dateOfElection;
    }

    public void setDateOfElection(LocalDate dateOfElection) {
        this.dateOfElection = dateOfElection;
    }
}
