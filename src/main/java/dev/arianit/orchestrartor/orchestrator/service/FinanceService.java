package dev.arianit.orchestrartor.orchestrator.service;

import dev.arianit.orchestrartor.dto.ApiResponse;
import dev.arianit.orchestrartor.dto.CashAdvanceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FinanceService {

    public ApiResponse cashAdvance(CashAdvanceDto request) {
        String status;
        String message;
        status = "PENDING";
        message = "Needs manager approval";
        return new ApiResponse(message, status);
    }

    public List<ApiResponse> getExpenseStatus(String userId) {
        return List.of(
                new ApiResponse("Expense approved", "APPROVED"),
                new ApiResponse("Expense rejected", "REJECTED")
        );
    }
}
