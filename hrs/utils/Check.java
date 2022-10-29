/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.utils;
import hrs.entities.Employee;
import java.util.ArrayList;
import java.util.Iterator;

public class Check {
    public static boolean isValidDate(String date) {
        // create a substring from the start of date string until the first "/"
        // that's the day of given date
        short day = Short.parseShort(date.substring(0, date.indexOf("/")));
        // a second substring from the first "/" to the last "/"
        // thats the month of given date
        short month = Short.parseShort(date.substring(date.indexOf("/") + 1, 
                                date.lastIndexOf("/")));
        // finally, a substring from the last "/" to 5 characters afterwards
        // that is the year
        short year = Short.parseShort(date.substring(date.lastIndexOf("/") + 1, 
                                date.lastIndexOf("/") + 5));
        
        if (day > 31 || month > 12 || year > 2022) return false;
       
        switch (month) {
            case 4: case 6: case 9: case 11:
                return day <= 30;
            case 2:
                boolean isLeapYear = (year % 100 == 0 || year % 4 == 0) 
                                    && year % 400 != 0;
                return day <= 28 || (day <= 29 && isLeapYear);
        }
        return day <= 31;
    }
    
    public static boolean isUniqueSSN(String check, ArrayList<Employee> list) {
        Iterator<Employee> It = list.iterator(); 
        while (It.hasNext()) {
            if (check.equalsIgnoreCase(It.next().getSSN())) 
                return false;
        }
        return true;
    }
}
