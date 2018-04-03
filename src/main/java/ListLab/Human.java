package ListLab;

public class Human {
    private String name;
    private String surname;
    private String fatherName;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (getAge() != human.getAge()) return false;
        if (getName() != null ? !getName().equals(human.getName()) : human.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(human.getSurname()) : human.getSurname() != null) return false;
        return getFatherName() != null ? getFatherName().equals(human.getFatherName()) : human.getFatherName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getFatherName() != null ? getFatherName().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getAge() {
        return age;
    }

    public Human(String name, String surname, String fatherName, int age) {

        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
    }


}
