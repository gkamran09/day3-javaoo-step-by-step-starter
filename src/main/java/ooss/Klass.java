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
        this.leader = student;
    }
    public Student getLeader() {
        return leader;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
