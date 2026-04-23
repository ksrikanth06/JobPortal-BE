package com.srikanth.jobportal.contact.controller;


import com.srikanth.jobportal.contact.service.impl.ContactServiceImpl;
import com.srikanth.jobportal.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {


    private final ContactServiceImpl contactService;


    @Autowired
    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }


    @PostMapping( path = "/public" , version = "1.0")
    public ResponseEntity<String> saveContactMessage(@RequestBody @Valid ContactRequestDto contactRequestDto){

      boolean isSaved =   contactService.saveContact(contactRequestDto);

      if(isSaved){
          return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving contact");
    }


    @GetMapping
    public ResponseEntity<String> getAllContacts(
            @RequestParam(name = "status")
            @Validated
            @NotBlank(message = "Status Required")
                    @Size(message = "Min 4 and Max 50 Char", min = 4, max = 50)
            String status
    ){
        return new ResponseEntity<>("All contacts of Staus: "+status, HttpStatus.OK);
    }

    @GetMapping("/getContacts/{status}")
    public ResponseEntity<String> getContacts(
            @PathVariable(name = "status")
            @Validated
            @NotBlank(message = "Status Required")
            @Size(message = "Min 4 and Max 50 Char", min = 4, max = 50)
            String status

    ){
        return new ResponseEntity<>("All contacts of Status : ", HttpStatus.OK);
    }

}
