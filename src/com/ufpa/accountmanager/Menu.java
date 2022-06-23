package com.ufpa.accountmanager;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Menu {

    private final AccountManager accountManager;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(AccountManager accountManager) {
        this.accountManager = accountManager;
        loadMainMenu();
    }

    public void loadMainMenu() {
        System.out.print(
            """
            Welcome to the Account Manager Main Menu
        
            1. Add Account
            2. List Accounts
            3. Delete Account
            0. Exit
            >\s"""
        );

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        switch (option) {
            case 0 -> {
                System.out.println("Exiting Account Manager");
                System.exit(0);
            }
            case 1 -> {
                addRoutine();
                loadMainMenu();
            }
            case 2 -> {
                listRoutine();
                loadMainMenu();
            }
            case 3 -> {
                deleteRoutine();
                loadMainMenu();
            }
            default -> loadMainMenu();
        }

    }

    public void addRoutine() {
        System.out.println("Adding a new account\n");

        System.out.print("Type new Username: ");
        String username = scanner.nextLine();

        System.out.print("Type user Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Type user Password: ");
        String password = scanner.nextLine();

        System.out.println();

        try {
            if (accountManager.addAccount(username, password, name))
                System.out.println("Account added successfully!\n");
            else
                System.out.println("The given Username already exists!\n");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void listRoutine() {
        try {
            String list = accountManager.listAccounts();
            System.out.println(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoutine() {
        System.out.println("Deleting account\n");

        System.out.print("Type the username for deletion: ");
        String username = scanner.nextLine();

        System.out.println();

        try {
            if (accountManager.removeAccount(username))
                System.out.println("Account deleted successfully!\n");
            else
                System.out.println("There is no account for the given Username!\n");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

