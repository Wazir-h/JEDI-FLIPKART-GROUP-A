package com.flipfit.client;

import java.util.Scanner;

public class GymAdminMenu {
    public static void adminPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Page loaded Succesfully");
        System.out.println("Please enter your choice:");
        System.out.println("1. Approve Gyms");
        System.out.println("2. Add Gyms");
        System.out.println("3. Delete Gyms");
        System.out.println("4. View Gyms");
        System.out.println("5. Add Gym Owner");
        System.out.println("6. Delete Gym Owner");
        String a = scanner.nextLine();
    }
}
