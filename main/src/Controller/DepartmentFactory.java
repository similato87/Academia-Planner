package Controller;

import Model.CSDepartment;
import Model.Department;
import Model.ECEDepartment;
import Model.SWEDepartment;

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
