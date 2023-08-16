package ooss;

import java.util.*;

public class Klass {
    private final int id;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private Student leader;

    public Klass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void assignLeader(Student student) {
        if (students.contains(student)) {
            leader = student;

            for (Teacher teacher : teachers) {
                teacher.printLeaderMessage(student, this); // Pass the student and class information
            }

            for (Student studentLeader : students) {
                studentLeader.printLeaderMessage(student, this); // Pass the student and class information
            }
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void attach(Person person) {
        if (person instanceof Student) {
            students.add((Student) person);
        } else if (person instanceof Teacher) {
            teachers.add((Teacher) person);
        }
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public boolean isTaughtBy(Teacher teacher) {
        return teachers.contains(teacher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klass klass = (Klass) o;

        return id == klass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
