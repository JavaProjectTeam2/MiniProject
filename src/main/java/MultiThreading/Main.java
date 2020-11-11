package MultiThreading;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("Welcome to Ecommerce Data Management System");
        System.out.println("********************************************");
        System.out.println("Main Menu: ");
        System.out.println("1. Valid Products Data");
        System.out.println("2. Data Processing Report");
        System.out.println("3. Exit");
        int menu = sc.nextInt();
        menuSwitch(menu);
    }

    public static void menuSwitch(int menu) {
        switch (menu) {
            case 1:
                MultithreadRead multithreadRead1 = new MultithreadRead(1, 10);
                MultithreadRead multithreadRead2 = new MultithreadRead(11, 20);
                MultithreadRead multithreadRead3 = new MultithreadRead(21, 30);
                MultithreadRead multithreadRead4 = new MultithreadRead(31, 40);
                MultithreadRead multithreadRead5 = new MultithreadRead(41, 50);
                multithreadRead1.start();
                multithreadRead2.start();
                multithreadRead3.start();
                multithreadRead4.start();
                multithreadRead5.start();
                break;
            case 2:
                break;
            case 3:
                System.out.println("Thank you...!");
                break;
            default:
                System.out.println("Invalid Choice! Try Again...");
                mainMenu();
                break;
        }
    }
}
