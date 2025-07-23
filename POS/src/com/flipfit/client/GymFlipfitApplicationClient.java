package com.flipfit.client;
import java.util.Scanner;

public class GymFlipfitApplicationClient {

    public static void main(String[] args) {
        System.out.println("Welcome to Flipfit Application");
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read a line of text

        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read an integer

        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        scanner.close();
    }
}
