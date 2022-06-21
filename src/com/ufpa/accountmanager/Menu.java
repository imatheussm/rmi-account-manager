package com.ufpa.accountmanager;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Menu {

	private AccountManager accountManager;
	private Scanner scanner = new Scanner(System.in);

	public Menu(AccountManager accountManager)
	{
		this.accountManager = accountManager;
		loadMainMenu();
	}

	public void loadMainMenu()
	{
		System.out.print(
				"Welcome to the Account Manager Main Menu\n\n" +
				"1. Add Account\n" +
				"2. List Accounts\n" +
				"3. Delete Account\n" +
				"0. Exit\n" +
				"> "
				);

		int option = scanner.nextInt();
		scanner.nextLine();
		System.out.println();

		switch(option){
			case 0:
				System.out.println("Exiting Account Manager");
				System.exit(0);
			case 1:
				addRoutine();
				loadMainMenu();
				break;
			case 2:
				listRoutine();
				loadMainMenu();
				break;
			case 3:
				deleteRoutine();
				loadMainMenu();
				break;
			default:
				loadMainMenu();
		}

	}

	public void addRoutine()
	{
		System.out.println("Adding a new account\n");

		System.out.print("Type new Username: ");
		String username = scanner.nextLine();

		System.out.print("Type user Full Name: ");
		String name = scanner.nextLine();

		System.out.print("Type user Password: ");
		String password = scanner.nextLine();
		
		System.out.println();

		try
		{
			accountManager.addAccount(username, password, name);
			System.out.println("Account added successfuly!\n");
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}

	}

	public void listRoutine()
	{
		try
		{
			String list = accountManager.listAccounts();
			System.out.println(list);
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteRoutine()
	{
		System.out.println("Deleting account\n");

		System.out.print("Type the Username for deleting: ");
		String username = scanner.nextLine();
		
		System.out.println();

		try
		{
			if(accountManager.removeAccount(username))
				System.out.println("Account deleted successfuly!\n");
			else
				System.out.println("There is no account for the given username\n");
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}

	}
}

