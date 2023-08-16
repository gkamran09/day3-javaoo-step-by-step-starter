package ooss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private Klass klass;
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }
    public void assignTo(Klass klass) {
        this.klass = klass;
    }

    public boolean belongsTo(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }
    public String introduce() {
        return String.format(super.introduce()+" I am a teacher.");
    }
}
