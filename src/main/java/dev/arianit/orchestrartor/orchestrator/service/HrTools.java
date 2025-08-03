package dev.arianit.orchestrartor.orchestrator.service;

import dev.arianit.orchestrartor.client.impl.HrServiceImpl;
import dev.arianit.orchestrartor.dto.ApiResponse;
import dev.arianit.orchestrartor.dto.hr.dto.CreateLeaveRequestDto;
import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveStatus;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class HrTools {

    private final ChatClient chatClient;
    private final HrServiceImpl hrService;
    private static final Long DEFAULT_EMPLOYEE_ID = 123L;


    public HrTools(ChatClient.Builder chatClient, HrServiceImpl hrService) {
        this.chatClient = chatClient.build();
        this.hrService = hrService;
    }

    @Tool(description = """
        Retrieve the remaining leave days for an employee.

        Behavior:
        - Returns a list of leave types and how many days are remaining for each (e.g., {"VACATION": 5, "SICK": 3}).
        - If the employeeId is missing or invalid, return an appropriate error message.

        Output:
        - A successful ApiResponse with remaining days in JSON format.
        - If an error occurs, return ApiResponse with status 'ERROR' and the error message.
    """)
    public ApiResponse getRemainingDaysByEmployeeId() {
        try {
            return hrService.getRemainingDays(DEFAULT_EMPLOYEE_ID);
        } catch (Exception e) {
            return new ApiResponse("Failed to fetch remaining days: " + e.getMessage(), "ERROR");
        }
    }

    @Tool(description = """
        Submit a leave request for an employee.

        Required fields:
        - type: The type of leave (e.g., VACATION, SICK, UNPAID).
        - startDate: Start of the leave (format YYYY-MM-DD).
        - endDate: End of the leave (format YYYY-MM-DD).

        Workflow:
        - Validate that all required fields are present and correctly formatted.
        - If any field is missing or invalid, return a message indicating which field(s) are problematic.
        - When valid, generate a summary: 
            "Employee {employeeId} is requesting {type} leave from {startDate} to {endDate}."
        - Ask the user for confirmation: "Do you want to proceed with submitting this leave request?"
        - Proceed only if user confirms with 'yes'.

        Output:
        - On success, return the created leave request wrapped in ApiResponse.
        - On failure, return an ApiResponse with error details and status 'ERROR'.
    """)
    public ApiResponse requestLeave(CreateLeaveRequestDto createLeaveRequestDto) {
        try {
            return hrService.createLeave(createLeaveRequestDto);
        } catch (Exception e) {
            return new ApiResponse("Failed to create leave: " + e.getMessage(), "ERROR");
        }
    }

    @Tool(description = """
        Update the approval status of an existing leave request.

        Required:
        - leaveId: The ID of the leave request to update.
        - leaveStatus: The new status (e.g., APPROVED, REJECTED, PENDING).

        Behavior:
        - Updates the leave request status in the HR system.
        - Ensure both leaveId and leaveStatus are provided and valid.

        Output:
        - Returns an ApiResponse indicating success.
        - On error, return ApiResponse with status 'ERROR' and details of what failed.
    """)
    public List<ApiResponse> updateStatusOfLeaveRequest(Integer leaveId, LeaveStatus leaveStatus) {
        try {
            ApiResponse response = hrService.updateLeaveStatus(leaveId, leaveStatus);
            return Collections.singletonList(response);
        } catch (Exception e) {
            return List.of(new ApiResponse("Failed to update leave status: " + e.getMessage(), "ERROR"));
        }
    }
}
