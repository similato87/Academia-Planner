package Model;

public class ECEDepartment implements Department{
    private final String departmentName = "Electrical Engineering Department";
    private final String departmentCode = "ECE";

    public ECEDepartment(){}
    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getDepartmentCode() {
        return departmentCode;
    }
}