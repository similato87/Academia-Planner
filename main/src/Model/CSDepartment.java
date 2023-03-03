package Model;

public class CSDepartment implements Department {
    private final String departmentName = "Computer Science Department";
    private final String departmentCode = "CS";

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}
