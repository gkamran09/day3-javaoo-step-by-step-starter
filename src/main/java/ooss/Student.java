package ooss;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }
    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }
    @Override
    public String introduce() {
        if (klass != null && klass.getLeader() != null && klass.getLeader().equals(this)) {
            return super.introduce() + " I am a student. I am the leader of class " + klass.getId() + ".";
        } else {
            return super.introduce() + " I am a student.";
        }
    }

}
