/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.entities;
import hrs.utils.Input;
import java.util.ArrayList;

public class Department {
    private String Name;
    private final ArrayList<Employee> EmpList = new ArrayList();

    public Department() {
        this.Name = Input.Str("department's name");
    }
    
    public Department(String name) {
        this.Name = name;
    }
    
    public String getDepartmentName() {
        return Name;
    }

    public int getDepartmentSize() {
        return EmpList.size();
    }
    
    public void setDepartmentName(String departmentName) {
        this.Name = departmentName;
    }
    
    public void addEmp(Employee toAdd) {
        EmpList.add(toAdd);
    }
    
    public void delEmp(Employee toDel) {
        if (EmpList.contains(toDel)) EmpList.remove(toDel);
    }
    
    public boolean contains(Employee toSearch) {
        return EmpList.contains(toSearch);
    }
    
    public void display() {
        short salcnt = 0, hrlcnt = 0;
        for (Employee emp : EmpList) {
            if (emp instanceof SalariedEmployee) salcnt++;
            else hrlcnt++;
        }       
        System.out.println("Department name: " + this.Name
                        + "\nNumber of employees: " + EmpList.size()
                        + "\nNumber of Salaried Employees: " + salcnt
                        + "\nNumber of Hourly Employees: " + hrlcnt);
    }
}
