package dev.arianit.orchestrartor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    public String message;
    public String status;

    public ApiResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
