package Model;

public class SWEDepartmentFactory implements DepartmentFactory{
    @Override
    public Department  createDepartment() {
        return new SWEDepartment();
    }
}