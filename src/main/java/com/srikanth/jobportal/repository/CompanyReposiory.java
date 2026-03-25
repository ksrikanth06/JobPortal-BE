package com.srikanth.jobportal.repository;

import com.srikanth.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyReposiory extends JpaRepository<Company, Long> {
}
