package factory_method;

public class CSDepartment implements Department {
    private final String departmentName = "Computer Science Department";
    private final String departmentCode = "CS";

    public CSDepartment(){}
    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}
