package com.example.contactsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.LiveData;

public class Repository {
    private final ContactsDAO contactDAO;

    // used for background database operations
    ExecutorService executor;

    // used for updating the UI
    Handler handler;

    public Repository(Application application) {
        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactDAO = contactsDatabase.getContactDAO();

        executor = Executors.newSingleThreadExecutor();

        handler = new Handler(Looper.getMainLooper());
    }



    public void addContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return contactDAO.getAllContacts();
    }
}
