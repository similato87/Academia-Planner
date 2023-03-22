package factory_method;

public class CSDepartmentFactory implements DepartmentFactory{
    @Override
    public Department  createDepartment() {
        return new CSDepartment();
    }
}
