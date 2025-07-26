package dev.arianit.orchestrartor.client.impl;

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

    public HrServiceImpl(HrServiceClient hrServiceClient) {
        this.hrServiceClient = hrServiceClient;
    }

    public ApiResponse<List<LeaveRequest>> getAllLeaves() {
        ResponseEntity<List<LeaveRequest>> response = hrServiceClient.getAllLeaves();
        String status = response.getStatusCode().toString();
        return new ApiResponse<>(response.getBody(), status);
    }

    public ApiResponse<LeaveRequest> createLeave(CreateLeaveRequestDto dto) {
        ResponseEntity<LeaveRequest> response = hrServiceClient.createLeave(dto);
        String status = response.getStatusCode().toString();
        return new ApiResponse<>(response.getBody(), status);
    }

    public ApiResponse<String> updateLeaveStatus(Integer leaveId, LeaveStatus statusEnum) {
        ResponseEntity<String> response = hrServiceClient.updateLeaveStatus(leaveId, statusEnum);
        String status = response.getStatusCode().toString();
        return new ApiResponse<>(response.getBody(), status);
    }

    public ApiResponse<RemainingDaysDto> getRemainingDays(String employeeId) {
        ResponseEntity<RemainingDaysDto> response = hrServiceClient.getRemainingDays(employeeId);
        String status = response.getStatusCode().toString();
        return new ApiResponse<>(response.getBody(), status);
    }
}
