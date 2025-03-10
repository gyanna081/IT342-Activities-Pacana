package com.IT342Activities.Pacana.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IT342Activities.Pacana.service.GoogleContactsService;
import com.google.api.services.people.v1.model.Person;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    private final com.IT342Activities.Pacana.service.GoogleContactsService googlePeopleService;

    public ContactsController(GoogleContactsService googlePeopleService) {
        this.googlePeopleService = googlePeopleService;
    }

    @GetMapping
    public List<Person> getContacts() throws IOException {
        List<Person> contacts = googlePeopleService.getContacts();
        System.out.println("Fetched Contacts: " + contacts);
        return contacts;
    }
}
