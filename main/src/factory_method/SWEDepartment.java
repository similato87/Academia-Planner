package factory_method;

public class SWEDepartment implements Department {
    private final String departmentName = "Software Engineering Department";
    private final String departmentCode = "SWE";

    public SWEDepartment(){}
    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}
