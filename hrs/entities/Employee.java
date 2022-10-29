/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.entities;

import hrs.utils.Input;

/**
 *
 * @author Dell
 */
abstract public class Employee implements Payable {
    private String SSN, firstName, lastName, birthDate, phone, email;

    public Employee() {
        this.firstName = Input.Str("first name");
        this.lastName = Input.Str("last name");
        this.SSN = Input.SSN();
        this.birthDate = Input.BirthDate();
        this.phone = Input.PhoneNum();
        this.email = Input.Email();
    }
    
    public Employee(String ssn, String firstName, String lastName) {
        this.SSN = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName() {
        this.firstName = Input.Str("first name");
    }

    public void setLastName() {
        this.lastName = Input.Str("last name");
    }

    public void setBirthDate() {
        this.birthDate = Input.BirthDate();
    }
    
    public void setBirthDate(String mess) {
        this.birthDate = Input.BirthDate(mess);
    }    
    
    public void setSSN() {
        this.SSN = Input.SSN();
    }
    
    public void setSSN(String mess) {
        this.SSN = Input.SSN(mess);
    }
    
    public void setPhone() {
        this.phone = Input.PhoneNum();
    }

    public void setPhone(String mess) {
        this.phone = Input.PhoneNum(mess);
    }
    
    public void setEmail() {
        this.email = Input.Email();
    }

    public void setEmail(String mess) {
        this.email = Input.Email(mess);
    }
    
    public void display() {
        System.out.println("\nFirst name: " + firstName
                        + "\nLast name: " + lastName
                        + "\nSSN: " + SSN
                        + "\nBirthday: " + birthDate
                        + "\nPhone: " + phone
                        + "\nEmail: " + email);
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + " " 
                + SSN + " " + birthDate + " " + phone + " " + email;
    }
}
