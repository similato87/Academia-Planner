package factory_method;

public class ECEDepartmentFactory implements DepartmentFactory{
    @Override
    public Department createDepartment() {
        return new ECEDepartment();
    }
}
