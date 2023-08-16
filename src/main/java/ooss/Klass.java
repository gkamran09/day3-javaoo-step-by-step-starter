package ooss;

public class Klass {
    private int id;
    private Student leader;
    private Teacher teacher;
    private Student student;

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
        if (student.isIn(this)) {
            student.setLeader(true);
            this.leader = student;
            if (teacher != null) {
                System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.%n",
                        teacher.getName(), id, student.getName());
            }
        } else {
            System.out.println("It is not one of us.");
        }
    }
    public Student getLeader() {
        return leader;
    }

    public boolean isLeader(Student student) {
        return leader != null && student != null && leader.getId() == student.getId();
    }
    public void attach(Person person) {
        if (person instanceof Teacher) {
            this.teacher = (Teacher) person;
        } else if (person instanceof Student) {
            Student student = (Student) person;
            student.join(this);
        }
    }


    @Override
    public int hashCode() {
        return id;
    }
}
