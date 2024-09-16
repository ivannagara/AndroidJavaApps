package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactsmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contacts contact = new Contacts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        handler = new AddNewContactClickHandler(
                contact,
                this,
                myViewModel
        );

        binding.setContact(contact);
        binding.setClickHandler(handler);
    }
}