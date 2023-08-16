package ooss;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Klass> assignedClasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        assignedClasses = new ArrayList<>();
    }
    public String getName() {
        return super.getName();
    }

    public void assignTo(Klass klass) {
        assignedClasses.add(klass);
        klass.attach(this);
    }

    public boolean belongsTo(Klass klass) {
        return assignedClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : assignedClasses) {
            if (student.isIn(klass)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String introduce() {
        StringBuilder classIds = new StringBuilder();
        for (Klass klass : assignedClasses) {
            classIds.append(klass.getId()).append(", ");
        }
        if (classIds.length() > 0) {
            classIds.delete(classIds.length() - 2, classIds.length());
            return super.introduce() + " I am a teacher. I teach Class " + classIds + ".";
        } else {
            return super.introduce() + " I am a teacher.";
        }
    }
}
