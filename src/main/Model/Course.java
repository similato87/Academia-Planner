package Model;

public class Course {

    private String name;


    public Course(String name) {

        this.name = name;

    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return getName().equals(course.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public void updateCourseName(String name)
    {
        this.name = name;
    }
}
