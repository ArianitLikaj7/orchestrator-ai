package dev.arianit.orchestrartor.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CashAdvanceDto {

    @NotBlank(message = "UserId is required")
    public String userId;

    @NotBlank(message = "Destination country is required")
    public String destinationCountry;

    @NotBlank(message = "City is required")
    public String city;

    @NotBlank(message = "ManagerId is required")
    public String managerId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    public Double amount;

    public CashAdvanceDto(String userId, String destinationCountry, String city, String managerId, double amount) {
        this.userId = userId;
        this.destinationCountry = destinationCountry;
        this.city = city;
        this.managerId = managerId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}