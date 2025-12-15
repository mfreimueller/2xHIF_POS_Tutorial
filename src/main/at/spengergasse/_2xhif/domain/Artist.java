package at.spengergasse._2xhif.domain;

import java.time.LocalDate;

public class Artist {
    private final String firstname, lastname;
    private final LocalDate birthday;

    public Artist(LocalDate birthday, String firstname, String lastname) {
        this.birthday = birthday;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
