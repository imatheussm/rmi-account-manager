package com.ufpa.accountmanager;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try
        {
            AccountManager accountManager = (AccountManager) Naming.lookup(
                    "//localhost:4123/AccountManagerService");

            System.out.println(accountManager.listAccounts());
            accountManager.addAccount(
                    "gabrielamaximino", "gabrielamaximino", "Gabriela Maximino");
            System.out.println(accountManager.listAccounts());
            accountManager.removeAccount("gigasmesh");
            System.out.println(accountManager.listAccounts());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
