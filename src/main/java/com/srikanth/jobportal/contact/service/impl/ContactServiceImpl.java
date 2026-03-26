package com.srikanth.jobportal.contact.service.impl;

import com.srikanth.jobportal.contact.service.IContactService;
import com.srikanth.jobportal.dto.ContactRequestDto;
import com.srikanth.jobportal.entity.Contact;
import com.srikanth.jobportal.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class ContactServiceImpl implements IContactService {


    private final ContactRepository contactRepository;


    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {

        Contact c =  contactRepository.save(transformToEntity(contactRequestDto));

        if(c != null & c.getId() != null) {
            return true;
        }
        return false;
    }


    private Contact transformToEntity(ContactRequestDto dto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(dto, contact);
      //  contact.setCreatedAt(Instant.now());
      //  contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }
}
