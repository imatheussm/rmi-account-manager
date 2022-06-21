package com.ufpa.accountmanager;

import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {
        try
        {
            AccountManager accountManager = (AccountManager) Naming.lookup(
                    "//127.0.0.1:4123/AccountManagerService");

			new Menu(accountManager);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
