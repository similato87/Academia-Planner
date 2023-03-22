package Model;

public class CSDepartmentFactory implements DepartmentFactory{
    @Override
    public Department  createDepartment() {
        return new CSDepartment();
    }
}