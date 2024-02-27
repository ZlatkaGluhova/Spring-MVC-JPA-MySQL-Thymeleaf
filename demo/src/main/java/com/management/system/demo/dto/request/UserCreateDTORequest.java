package com.management.system.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.system.demo.exception.InvalidAgeException;
import com.management.system.demo.model.Role;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

//@Validated
//@JsonPropertyOrder({"username", "password", "email", "age", "birthDate", "isActive", "roles"})
public class UserCreateDTORequest {


    @NotBlank(message = "Username not found!!!")
    @Size(min = 3, max = 15)
    protected String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    protected String password;

    @NotNull
    @Email(message = "Email is not valid!")
    protected String email;

    protected Integer age;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected LocalDate birthDate;

    protected Boolean isActive = true;

    protected List<Role> roles;

    public UserCreateDTORequest() {
    }

    public UserCreateDTORequest(String username, String password, String email, Integer age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public UserCreateDTORequest(String username, String password, String email, Integer age, Boolean isActive, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.roles = roles;
    }

    public UserCreateDTORequest(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void checkAge(LocalDate birthDate) {
        LocalDate dateNow = LocalDate.now();
        int currentAge = Period.between(birthDate, dateNow).getYears();

        if (currentAge < 18) {
            throw new InvalidAgeException("You are under 18 years old.");
        }

        this.age = currentAge;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        checkAge(birthDate);
        this.birthDate = birthDate;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDTORequest that = (UserCreateDTORequest) o;
        return age == that.age &&
                isActive == that.isActive &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roles);
    }

    @Override
    public String toString() {
        return "UserCreateDTORequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", roles=" + roles +
                '}';
    }
}

