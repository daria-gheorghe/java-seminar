import java.util.Objects;

public class Student implements Comparable<Student>
{

        public String name;
        public int grade;

        public Student(){}
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name + " " + grade;
        }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o)
    {
            if(this==o) return true;
        if (!(o instanceof Student)) return false;
        Student s=(Student)o;
        return grade == s.grade && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}
