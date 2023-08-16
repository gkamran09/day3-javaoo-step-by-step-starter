package ooss;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Klass> assignedClasses; // List of classes the teacher is assigned to

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        assignedClasses = new ArrayList<>();
    }

    public void assignTo(Klass klass) {
        assignedClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return assignedClasses.contains(klass);
    }

    @Override
    public String introduce() {
        StringBuilder classNames = new StringBuilder();
        for (Klass klass : assignedClasses) {
            classNames.append(klass.getId()).append(", ");
        }
        if (classNames.length() > 0) {
            classNames.delete(classNames.length() - 2, classNames.length()); // Remove the trailing comma and space
        }
        return String.format(super.introduce() + " I am a teacher. I teach Class %s.", classNames);
    }
}
