package com.ufpa.accountmanager;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args)
    {
        try {
            LocateRegistry.createRegistry(1020);

            AccountManager accountManager = new AccountManagerImpl();
            Naming.rebind("rmi://127.0.0.1:1020/AccountManagerService", accountManager);

            accountManager.populateWithAccounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
