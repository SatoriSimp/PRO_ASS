/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.entities;

import hrs.utils.Input;

public class SalariedEmployee extends Employee {
    private double commissionRate, grossSale, basicSalary;

    public SalariedEmployee() {
        super();
        this.basicSalary = Input.Doub("basic salary");
        this.commissionRate = Input.Doub("commission rate");
        this.grossSale = Input.Doub("gross sale");
    }
    
    public double getCommissionRate() {
        return commissionRate;
    }
    
    public double getGrossSale() {
        return grossSale;
    }
    
    public double getBasicSalary() {
        return basicSalary;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    public void setCommissionRate() {
        this.commissionRate = Input.Doub("commission rate");
    }

    public void setCommissionRate(String customMess) {
        this.commissionRate = Input.Doub(customMess);
    }
    
    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }

    public void setGrossSale() {
        this.grossSale = Input.Doub("gross sale");
    }
    
    public void setGrossSale(String customMess) {
        this.grossSale = Input.Doub(customMess);
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    
    public void setBasicSalary() {
        this.basicSalary = Input.Doub("basic salary");
    }

    public void setBasicSalary(String customMess) {
        this.basicSalary = Input.Doub(customMess);
    }
    
    @Override
    public double getPaymentAmount() {
        return basicSalary + grossSale * commissionRate / 100;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " 
                + basicSalary + " " + grossSale + " " + commissionRate;
    }
}
