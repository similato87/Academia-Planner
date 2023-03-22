package factory_method;

public class SWEDepartmentFactory implements DepartmentFactory{
    @Override
    public Department createDepartment() {
        return new SWEDepartment();
    }
}
