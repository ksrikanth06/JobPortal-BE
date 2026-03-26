package com.srikanth.jobportal.contact.service;

import com.srikanth.jobportal.dto.ContactRequestDto;

public interface IContactService {


   boolean saveContact(ContactRequestDto contactRequestDto);

}
