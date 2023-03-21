package factory_method;

import factory_method.CSDepartment;
import factory_method.Department;
import factory_method.ECEDepartment;
import factory_method.SWEDepartment;

public class DepartmentFactory {
    public static Department createDepartment(String departmentType) {
        if (departmentType.equalsIgnoreCase("CS")) {
            return new CSDepartment();
        } else if (departmentType.equalsIgnoreCase("SWE")) {
            return new SWEDepartment();
        } else if( departmentType.equalsIgnoreCase("ECE")){
            return new ECEDepartment();
        }
        else {
            throw new IllegalArgumentException("Invalid department type: " + departmentType);
        }
    }
}
