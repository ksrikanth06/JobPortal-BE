package com.srikanth.jobportal.company.service.impl;

import com.srikanth.jobportal.dto.CompanyDto;
import com.srikanth.jobportal.entity.Company;
import com.srikanth.jobportal.repository.CompanyReposiory;
import com.srikanth.jobportal.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyService implements ICompanyService {

    private final CompanyReposiory companyReposiory;

    @Autowired
    public CompanyService(CompanyReposiory companyReposiory) {
        this.companyReposiory = companyReposiory;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyReposiory.findAll();
       return companies.stream().map(this::transformToDto).collect(Collectors.toList());
    }

    private CompanyDto transformToDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt());
    }
}
