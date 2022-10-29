/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.main;

import hrs.utils.Input;

/**
 *
 * @author Dell
 */
public class Menu {
    private static final String[] Options = {
        "Add an employee",
        "Display employees",
        "Classify employees",
        "Search employee",
        "Update an employee",
        "Delete an employee",
        "Report",
        "Exit program"
    };
    
    public static void display() {
        System.out.println("======EMPLOYEE MANAGEMENT SYSTEM======");
        for (int i = 0; i < Options.length; ++i) {
            System.out.println((i + 1) + ". " + Options[i]);
        }
        System.out.println("Choose function you'd like to do!");
    }
}
