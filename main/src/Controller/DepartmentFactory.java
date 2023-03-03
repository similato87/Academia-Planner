package Controller;

import Model.CSDepartment;
import Model.Department;
import Model.SWEDepartment;

public class DepartmentFactory {
    public static Department createDepartment(String departmentType) {
        if (departmentType.equalsIgnoreCase("CS")) {
            return new CSDepartment();
        } else if (departmentType.equalsIgnoreCase("SWE")) {
            return new SWEDepartment();
        } else {
            throw new IllegalArgumentException("Invalid department type: " + departmentType);
        }
    }
}
