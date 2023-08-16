package ooss;

public class Student extends Person {
    private Klass klass;
    private boolean isLeader;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }
    public void join(Klass klass) {
        this.klass = klass;
    }
    public String getName() {
        return super.getName();
    }

    public boolean isIn(Klass klass) {
        return this.klass != null && this.klass.equals(klass);
    }
    public void setLeader(boolean leader) {
        isLeader = leader;
    }
    public boolean isLeader() {
        return isLeader;
    }
    public void assignLeader() {
        if (klass != null) {
            klass.assignLeader(this);
        }
    }

    @Override
    public String introduce() {
        String intro = super.introduce() + " I am a student.";

        if (isLeader && klass != null && klass.isLeader(this)) {
            intro += " I am the leader of class " + klass.getId() + ".";
        } else if (klass != null) {
            intro += " I am in class " + klass.getId() + ".";
        }

        return intro;
    }


}
