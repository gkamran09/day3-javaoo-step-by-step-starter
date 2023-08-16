package ooss;

public class Student extends Person {

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format(super.introduce()+" I am a student.");
    }
}
