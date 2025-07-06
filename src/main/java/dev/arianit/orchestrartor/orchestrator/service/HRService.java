package dev.arianit.orchestrartor.orchestrator.service;

import dev.arianit.orchestrartor.dto.ApiResponse;
import dev.arianit.orchestrartor.dto.LeaveRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {

    public ApiResponse getVacationDays(String userId) {
        return new ApiResponse("Vacation days", String.valueOf(15));
    }

    public ApiResponse requestLeave(LeaveRequestDto leaveRequest) {
        return new ApiResponse("Leave request submitted!", "OK");
    }

    public List<ApiResponse> getLeaveStatus(String userId) {
        return List.of(
                new ApiResponse("Leave approved", "APPROVED"),
                new ApiResponse("Leave pending", "PENDING")
        );
    }
}
