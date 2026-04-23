package com.srikanth.jobportal.company.service.impl;

import com.srikanth.jobportal.dto.CompanyDto;
import com.srikanth.jobportal.dto.JobDto;
import com.srikanth.jobportal.entity.Company;
import com.srikanth.jobportal.entity.Job;
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
       return companies.stream().map(this::transformCompanyToDto).collect(Collectors.toList());
    }

    private CompanyDto transformCompanyToDto(Company company) {
        List<JobDto> jobDtos = company.getJobs().stream()
                .map(this::transformJobToDto)
                .collect(Collectors.toList());
        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt(),jobDtos);
    }

    private JobDto transformJobToDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getCompany().getId(),
                job.getCompany().getName(),
                job.getCompany().getLogo(),
                job.getLocation(),
                job.getWorkType(),
                job.getJobType(),
                job.getCategory(),
                job.getExperienceLevel(),
                job.getSalaryMin(),
                job.getSalaryMax(),
                job.getSalaryCurrency(),
                job.getSalaryPeriod(),
                job.getDescription(),
                job.getRequirements(),
                job.getBenefits(),
                job.getPostedDate(),
                job.getApplicationDeadline(),
                job.getApplicationsCount(),
                job.getFeatured(),
                job.getUrgent(),
                job.getRemote(),
                job.getStatus()
        );
    }
}
