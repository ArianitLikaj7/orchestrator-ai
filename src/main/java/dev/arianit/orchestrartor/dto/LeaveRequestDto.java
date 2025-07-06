package dev.arianit.orchestrartor.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class LeaveRequestDto {

    public String userId = UUID.randomUUID().toString();

    @NotBlank(message = "FromDate is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "FromDate must be in format YYYY-MM-DD")
    public String fromDate;

    @NotBlank(message = "ToDate is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "ToDate must be in format YYYY-MM-DD")
    public String toDate;

    @NotBlank(message = "Reason is required")
    @Size(min = 3, max = 255, message = "Reason must be between 3 and 255 characters")
    public String reason;

    public LeaveRequestDto(String userId, String fromDate, String toDate, String reason) {
        this.userId = userId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}