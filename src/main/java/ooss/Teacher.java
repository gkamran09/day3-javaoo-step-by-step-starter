package ooss;

import java.util.*;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private Set<Klass> classes = new HashSet<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.isTeacher = true;
    }


    public void assignTo(Klass klass) {
        classes.add(klass);
        klass.attach(this); // Associate the teacher with the class
    }

    public boolean belongsTo(Klass klass) {
        return classes.contains(klass);
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (student.isIn(klass) && klass.isTaughtBy(this)) {
                return true;
            }
        }
        return false;
    }

    public void printLeaderMessage(Student student, Klass klass) {
        System.out.println("I am " + getName() + ", teacher of Class " + klass.getId() +
                ". I know " + student.getName() + " become Leader.");
    }

    @Override
    public String introduce() {
        String introduction = super.introduce();
        introduction += " I am a teacher.";

        if (!classes.isEmpty()) {
            String classList = classes.stream()
                    .map(klass -> " " + klass.getId())
                    .collect(Collectors.joining(","));

            introduction += " I teach Class" + classList + ".";
        }

        return introduction;
    }
}

