package at.spengergasse.santa.domain;

import at.spengergasse.santa.repository.PresentRepository;

import java.util.ArrayList;
import java.util.List;

public class Elf {
    private Long id;
    private final String name;
    private final int age;

    private List<Present> presents = new ArrayList<>();

    public Elf(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Elf(Long id, String name, int age, List<Present> presents) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.presents = presents;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Present> getPresents() {
        return presents;
    }

    public void addPresent(Present present) {
        presents.add(present);
    }

    public void removePresent(Present present) {
        presents.remove(present);
    }
}
