package ooss;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.isTeacher = false;
    }

    public void join(Klass klass) {
        this.klass = klass;
        klass.attach(this); // Associate the student with the class
    }
    public void printLeaderMessage(Student student, Klass klass) {
            System.out.println("I am " + getName() + ", student of Class " + klass.getId() +
                    ". I know " + student.getName() + " become Leader.");
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }

    public boolean isLeader() {
        return klass != null && klass.isLeader(this);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce();
        introduction += " I am a student.";

        if (isLeader()) {
            introduction += " I am the leader of class " + klass.getId() + ".";
        } else if (klass != null) {
            introduction += " I am in class " + klass.getId() + ".";
        }

        return introduction;
    }
}
