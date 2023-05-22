package sg.edu.nus.iss.visa.ssf_day14workshop.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {
    
    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    @Size(min = 7, message = "Invalid Phone number")
    private String phoneNumber;

    @Past(message = "Date of Birth should not be from future")
    @NotNull(message = "Date of Birth is mandatory")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dob;

    @Min(value = 10, message = "Must be above 10 years old")
    @Max(value = 100, message = "Must be below 100 years old")
    private int age;

    private String id;

    public Contact() {
    }

    public Contact(@NotNull(message = "Name cannot be empty") String name,
            @NotEmpty(message = "Email cannot be empty") @Email(message = "Invalid email") String email,
            @Size(min = 7, message = "Invalid Phone number") String phoneNumber,
            @Past(message = "Date of Birth should not be from future") @NotNull(message = "Date of Birth is mandatory") LocalDate dob,
            @Min(value = 10, message = "Must be above 10 years old") @Max(value = 100, message = "Must be below 100 years old") int age,
            String id) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

}
