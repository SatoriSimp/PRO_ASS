package hrs.service;

import hrs.entities.*;
import hrs.utils.Input;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author Dell
 */
public class Functional {
    // a list of departments
    private static final ArrayList<Department> DepList = new ArrayList();
    // a list of all employees from all departments
    private static final ArrayList<Employee> EmployeeList = new ArrayList();
    
    public static void addEmployee() {
        Employee temp;
        System.out.println("Employee type:\n1. Salaried\n2. Hourly");
        short choice = Input.Shrt((short)1, (short)2);
        temp = (choice == 1) ? new SalariedEmployee() : new HourlyEmployee();
        
        System.out.println("Which department do they belong to?");
        String getName = Input.Str("department's name");
        
        // if a department with such name has already existed, 
        // add the employee to said department. 
        // if not, create a new one before adding
        boolean DepExisted = false;
        Iterator<Department> DepIt = DepList.iterator();
        while (DepIt.hasNext()) {
            Department currDep = DepIt.next();
            if (getName.equalsIgnoreCase(currDep.getDepartmentName())) {
                currDep.addEmp(temp);
                DepExisted = true;
                break;
            }
        }
        
        if (!DepExisted) {
            Department newDep = new Department(getName);
            newDep.addEmp(temp);
            DepList.add(newDep);
        }
        
        EmployeeList.add(temp);
        System.out.println("Employee added!");
    }
    
    public static void displaySorted() {
        if (emptyList()) return;
        System.out.println("Display method:\n1. Sort by name\n2. Sort by SSN");
        short meth = Input.Shrt("your choice", (short)1, (short)2);
        
        // create a temp list to sort without changing the original order
        ArrayList<Employee> tempList = EmployeeList;
        if (meth == 1) {
            Collections.sort(tempList, (Employee e1, Employee e2)
                    -> e1.getFirstName().compareTo(e2.getFirstName()));
            System.out.println("Sorted by name!");
        }
        else {
            Collections.sort(tempList, (Employee e1, Employee e2)
                    -> e1.getSSN().compareTo(e2.getSSN()));
            System.out.println("Sorted by SSN!");
        }

        // dsiplay list
        tempList.forEach(emp -> emp.display());
    }
    
    public static void classifyEmp() {
        if (emptyList()) return;
        ArrayList<Employee> SalEmp = new ArrayList<>(),
                            HrlEmp = new ArrayList<>();
        
        EmployeeList.forEach(emp -> {
            if (emp instanceof SalariedEmployee) SalEmp.add(emp);
            else HrlEmp.add(emp);
        });
        
        System.out.println("List of Salaried Employees:");
        SalEmp.forEach(sle -> sle.display());
        System.out.println();
        System.out.println("List of Hourly Employees:");
        HrlEmp.forEach(hle -> hle.display());
        System.out.println();
    }
    
    public static void searchEmp() {
        if (emptyList()) return;
        System.out.println("Search by:\n1. Department\n2. Name");
        short meth = Input.Shrt("your choice", (short)1, (short)2);
        if (meth == 1) {
            String targetDep = Input.Str("department's name");
            for (Department dep : DepList) {
                if (targetDep.equalsIgnoreCase(dep.getDepartmentName())) {
                    System.out.println("Department found!");
                    EmployeeList.forEach(emp -> {
                        if (dep.contains(emp)) emp.display();
                    });
                    return;
                }
            }
            System.out.println("No department found!");
        }
        else {
            boolean found = false;
            String targetEmp = Input.Str("employee's name (last name + first name)");
            for (Employee emp : EmployeeList) {
                if (targetEmp.equalsIgnoreCase(emp.getLastName() + " " + emp.getFirstName())) {
                    emp.display();
                    found = true;
                }
            }
            if (!found) System.out.println("No employee has such name!");
        }
    }
    
    public static void updateEmp() {
        if (emptyList()) return;
        String toSearch = Input.Str("employee's SSN");
        Employee target = findEmpwithSSN(toSearch);
        if (target == null) {
            System.out.println("No employee found!");
            return;
        }
        
        ArrayList<String> options = new ArrayList();
        Collections.addAll(options,
            "Name",
            "SSN",
            "Phone number",
            "Email",
            "Birthdate"
        );
        if (target instanceof SalariedEmployee) {
           Collections.addAll(options, 
                            "Commission rate", 
                            "Gross sales", 
                            "Basic salary");
        }
        else if (target instanceof HourlyEmployee) {
            Collections.addAll(options, 
                            "Wage", 
                            "Working hours");
        }

        System.out.println("Pick a field to update:");
        for (short i = 0; i < options.size(); ++i) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        
        switch (Input.Shrt((short)1, (short)options.size())) {
            case 1:
                System.out.println("Current name: " 
                        + target.getLastName() + " " + target.getFirstName()
                        + "\nSet a new name:");
                target.setFirstName();
                target.setLastName();
                break;
            case 2:
                System.out.println("Current SSN: " + target.getSSN());
                target.setSSN("new SSN");
                break;
            case 3:
                System.out.println("Current phone number: " + target.getPhone());
                target.setPhone("new phone number");
                break;
            case 4:
                System.out.println("Current email: " + target.getEmail());
                target.setEmail("new email");
                break;
            case 5:
                System.out.println("Current birthdate: " + target.getBirthDate());
                target.setBirthDate("new birthdate");
                break;
            case 6:
                if (target instanceof SalariedEmployee) {
                    System.out.println("Current commission rate: "
                        + ((SalariedEmployee)target).getCommissionRate());
                    ((SalariedEmployee)target).setCommissionRate("new commission rate");
                }
                else if (target instanceof HourlyEmployee) {
                    System.out.println("Current wage: " 
                            + ((HourlyEmployee) target).getWage());
                    ((HourlyEmployee) target).setWage("new wage");
                }
                break;
            case 7:
                if (target instanceof SalariedEmployee) {
                    System.out.println("Current gross sales:" 
                        + ((SalariedEmployee) target).getGrossSale());
                    ((SalariedEmployee)target).setGrossSale("new gross sales");
                }
                else if (target instanceof HourlyEmployee) {
                    System.out.println("Current working hours: "
                        + ((HourlyEmployee) target).getWorkingHours());
                    ((HourlyEmployee) target).setWorkingHours("new working hours");
                }
                break;
            case 8:
                System.out.println("Current salary: " 
                        + ((SalariedEmployee)target).getBasicSalary());
                ((SalariedEmployee)target).setBasicSalary("new salary");
                break;
        }
        System.out.println("Updated!");
    }
    
    public static void deleteEmployee() {
        if (emptyList()) return;
        String toSearch = Input.Str("employee's SSN");
        Employee target = findEmpwithSSN(toSearch);
        if (target == null) {
            System.out.println("This employee's SSN doesn't exist, no action needed!");
            return;
        }
        System.out.println("Employee with SSN of " + target.getSSN()
                            + " has been removed!");
        EmployeeList.remove(target);
        DepList.forEach(dep -> dep.delEmp(target));

        Iterator<Department> it = DepList.iterator();
        while (it.hasNext()) {
            Department toDel = it.next();
            if (toDel.getDepartmentSize() == 0) DepList.remove(toDel);
            break;
        }
        //garbage collection will take care of the leftover objects
    }
    
    public static void report() {
        if (emptyList()) return;
        System.out.println("Total number of departments: " + DepList.size());
        DepList.forEach(dep -> dep.display());
    }
    
    public static Employee findEmpwithSSN(String SSN) {
        return EmployeeList.stream()
                        .filter(emp -> SSN.equalsIgnoreCase(emp.getSSN()))
                        .findFirst().orElse(null);
    }
    
    public static boolean emptyList() { 
        if (EmployeeList.isEmpty()) System.out.println("List is currently empty!");
        return EmployeeList.isEmpty(); 
    }
    
    public static ArrayList<Employee> getList() {
        return EmployeeList;
    }
}
