package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository repo;

    // Live Data
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.repo = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = repo.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contact) {
        repo.addContact(contact);
    }

    public void deleteContact(Contacts contact) {
        repo.deleteContact(contact);
    }
}
