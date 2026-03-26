package com.srikanth.jobportal.contact.controller;


import com.srikanth.jobportal.contact.service.impl.ContactServiceImpl;
import com.srikanth.jobportal.dto.ContactRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {


    private final ContactServiceImpl contactService;


    @Autowired
    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }


    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMessage(@RequestBody ContactRequestDto contactRequestDto){

      boolean isSaved =   contactService.saveContact(contactRequestDto);

      if(isSaved){
          return ResponseEntity.ok("Contact saved successfully");
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
