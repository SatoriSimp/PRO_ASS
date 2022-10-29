package hrs.entities;

import hrs.utils.Input;

public class HourlyEmployee extends Employee {
    private double wage, workingHours;

    public HourlyEmployee() {
        super();
        this.wage = Input.Doub("wage");
        this.workingHours = Input.Doub("working hours");
    }
    
    public double getWage() {
        return wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setWage() {
        this.wage = Input.Doub("wage");
    }
    
    public void setWage(String customMess) {
        this.wage = Input.Doub(customMess);
    }
    
    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
    
    public void setWorkingHours() {
        this.workingHours = Input.Doub("working hours");
    }
    
    public void setWorkingHours(String customMess) {
        this.workingHours = Input.Doub(customMess);
    }
    
    @Override
    public double getPaymentAmount() {
        return wage * workingHours;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + wage + " " + workingHours;
    }
}
