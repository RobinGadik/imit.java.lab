package ListLab;

public class Student extends Human {
    private String faculty;
    public Student(String name, String surname, String fatherName, int age, String faculty) {
        super(name, surname, fatherName, age);
        this.faculty = faculty;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return getFaculty() != null ? getFaculty().equals(student.getFaculty()) : student.getFaculty() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFaculty() != null ? getFaculty().hashCode() : 0);
        return result;
    }

    public String getFaculty() {

        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
