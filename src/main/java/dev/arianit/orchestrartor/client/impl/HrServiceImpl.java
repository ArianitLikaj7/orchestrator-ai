package dev.arianit.orchestrartor.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.arianit.orchestrartor.client.HrServiceClient;
import dev.arianit.orchestrartor.dto.ApiResponse;
import dev.arianit.orchestrartor.dto.hr.dto.CreateLeaveRequestDto;
import dev.arianit.orchestrartor.dto.hr.dto.RemainingDaysDto;
import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveStatus;
import dev.arianit.orchestrartor.dto.hr.request.LeaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrServiceImpl {

    private final HrServiceClient hrServiceClient;
    private final ObjectMapper objectMapper;

    public HrServiceImpl(HrServiceClient hrServiceClient, ObjectMapper objectMapper) {
        this.hrServiceClient = hrServiceClient;
        this.objectMapper = objectMapper;
    }

    public ApiResponse getAllLeaves() throws JsonProcessingException {
        ResponseEntity<List<LeaveRequest>> response = hrServiceClient.getAllLeaves();
        String status = ((HttpStatus) response.getStatusCode()).name();
        String body = objectMapper.writeValueAsString(response.getBody());
        return new ApiResponse(body, status);
    }

    public ApiResponse createLeave(CreateLeaveRequestDto dto) throws JsonProcessingException {
        ResponseEntity<LeaveRequest> response = hrServiceClient.createLeave(dto);
        String status = ((HttpStatus) response.getStatusCode()).name();
        String body = objectMapper.writeValueAsString(response.getBody());
        return new ApiResponse(body, status);
    }

    public ApiResponse updateLeaveStatus(Integer leaveId, LeaveStatus statusEnum) {
        ResponseEntity<String> response = hrServiceClient.updateLeaveStatus(leaveId, statusEnum);
        String status = ((HttpStatus) response.getStatusCode()).name();
        return new ApiResponse(response.getBody(), status);
    }

    public ApiResponse getRemainingDays(String employeeId) throws JsonProcessingException {
        ResponseEntity<RemainingDaysDto> response = hrServiceClient.getRemainingDays(employeeId);
        String status = ((HttpStatus) response.getStatusCode()).name();
        String body = objectMapper.writeValueAsString(response.getBody());
        return new ApiResponse(body, status);
    }
}
