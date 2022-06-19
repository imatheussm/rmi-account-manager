package com.ufpa.accountmanager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AccountManagerImpl extends UnicastRemoteObject implements AccountManager {
    private final ArrayList<Account> accounts = new ArrayList<>();

    AccountManagerImpl() throws RemoteException {
        super();
    }

    public void populateWithAccounts() throws RemoteException {
        addAccount("gigasmesh", "gigasmesh", "Giovanne Souza");
        addAccount("ygarasab", "ygarasab", "Eduardo Cardoso");
        addAccount("imatheussm", "imatheussm", "Igor Moreira");
    }

    public boolean addAccount(Account account) throws RemoteException {
        if (!isUsernameInUse(account.getUsername())) {
            accounts.add(account);

            return true;
        }

        return false;
    }

    public boolean addAccount(String username, String password, String name) throws RemoteException {
        if (!isUsernameInUse(username)) {
            accounts.add(new Account(username, password, name));

            return true;
        }

        return false;
    }

    public boolean removeAccount(Account account) throws RemoteException {
        if (isUsernameInUse(account.getUsername())) {
            accounts.removeIf(anAccount -> anAccount.equals(account));

            return true;
        }

        return false;
    }

    public boolean removeAccount(String username) throws RemoteException {
        if (isUsernameInUse(username)) {
            accounts.removeIf(anAccount -> anAccount.getUsername().equals(username));

            return true;
        }

        return false;
    }

    public String listAccounts() throws RemoteException {
        StringBuilder output = new StringBuilder("Account list\n");

        for (Account anAccount : accounts)
            output.append(anAccount);

        return output.toString();
    }

    private boolean isUsernameInUse(String username) {
        return accounts.stream().anyMatch(account -> account.getUsername().equals(username));
    }
}
