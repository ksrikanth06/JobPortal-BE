package com.srikanth.jobportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.srikanth.jobportal.entity.Contact}
 */
public record ContactRequestDto(

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid Email")
        String email,

        @NotBlank(message = "message cannot be empty")
        @Size(max = 500, min = 5, message = "Min 5, Max 500 Characters")
        String message,

        @NotBlank(message = "name cannot be empty")
        @Size(max = 50, min = 5, message = "Min 5, Max 50 Characters")
        String name,

        @NotBlank(message = "subject cannot be empty")
        @Size(max = 500, min = 5, message = "Min 5, Max 500 Characters")
        String subject,

        @NotBlank  (message = "userType cannot be empty")
        String userType)

        implements Serializable {
}