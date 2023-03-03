package Model;

public class SWEDepartment implements Department {
    private final String departmentName = "Software Engineering Department";
    private final String departmentCode = "SWE";

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}
