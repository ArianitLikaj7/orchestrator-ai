package dev.arianit.orchestrartor.client.impl;

import dev.arianit.orchestrartor.client.HrServiceClient;
import dev.arianit.orchestrartor.dto.ApiResponse;
import dev.arianit.orchestrartor.dto.hr.dto.CreateLeaveRequestDto;
import dev.arianit.orchestrartor.dto.hr.request.LeaveRequest;
import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HrServiceImpl {

    private final HrServiceClient hrServiceClient;

    public HrServiceImpl(HrServiceClient hrServiceClient) {
        this.hrServiceClient = hrServiceClient;
    }

    public ApiResponse<List<LeaveRequest>> getAllLeaves() {
        ResponseEntity<List<LeaveRequest>> response = hrServiceClient.getAllLeaves();
        return new ApiResponse<>(response.getBody(), response.getStatusCode().toString());
    }

    public ApiResponse<LeaveRequest> createLeave(CreateLeaveRequestDto dto) {
        ResponseEntity<LeaveRequest> response = hrServiceClient.createLeave(dto);
        return new ApiResponse<>(response.getBody(), response.getStatusCode().toString());
    }

    public ApiResponse<String> updateLeaveStatus(Integer leaveId, LeaveStatus statusEnum) {
        Map<String, String> body = Map.of("status", statusEnum.name());
        ResponseEntity<String> response = hrServiceClient.updateLeaveStatus(leaveId, body);
        return new ApiResponse<>(response.getBody(), response.getStatusCode().toString());
    }

    public ApiResponse<Map<String, Object>> getRemainingDays(Long employeeId) {
        ResponseEntity<Map<String, Object>> response = hrServiceClient.getRemainingDays(employeeId);
        return new ApiResponse<>(response.getBody(), response.getStatusCode().toString());
    }
}
