package factory_method;

import factory_method.CSDepartment;
import factory_method.Department;
import factory_method.ECEDepartment;
import factory_method.SWEDepartment;

public interface DepartmentFactory {


    public Department createDepartment();
}
