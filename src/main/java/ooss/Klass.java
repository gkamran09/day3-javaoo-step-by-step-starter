package ooss;

public class Klass {
    private int id;
    private Student leader;

    public Klass(int id) {
    this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klass klass = (Klass) o;

        return id == klass.id;
    }
    public int getId() {
        return id;
    }
    public void assignLeader(Student student) {
        if (!student.isIn(this)) {
            System.out.println("It is not one of us.");
        } else {
            this.leader = student;
        }
    }
    public Student getLeader() {
        return leader;
    }
    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
