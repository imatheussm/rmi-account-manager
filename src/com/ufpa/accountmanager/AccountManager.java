package com.ufpa.accountmanager;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountManager extends Remote {

    boolean addAccount(Account account) throws RemoteException;
    boolean addAccount(String username, String password, String name) throws RemoteException;
    boolean removeAccount(Account account) throws RemoteException;
    boolean removeAccount(String username) throws RemoteException;
    String listAccounts() throws RemoteException;
    void populateWithAccounts() throws RemoteException;
}
