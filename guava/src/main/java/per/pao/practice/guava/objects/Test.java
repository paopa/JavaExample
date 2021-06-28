package per.pao.practice.guava.objects;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Data;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s1.toString());
    }
}

@Data
class Student {
    private final String firstName;
    private final String lastName;
    private final int rollNo;
    private final String className;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student) || object == null) {
            return false;
        }
        Student student = (Student) object;
        return Objects.equal(firstName, student.firstName) &&
                Objects.equal(lastName, student.lastName) &&
                Objects.equal(rollNo, student.rollNo) &&
                Objects.equal(className, student.className);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(rollNo, className);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", this.firstName)
                .add("lastName", this.lastName)
                .add("rollNo", this.rollNo)
                .add("className", this.className)
                .toString();
    }
}
