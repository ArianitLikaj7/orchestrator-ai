package dev.arianit.orchestrartor.orchestrator.service;

import dev.arianit.orchestrartor.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.List;

@Component
public class HrTools {
    private final ChatClient chatClient;

    @Value("classpath:/images/test.jpg")
    private Resource sampleImage;

    public HrTools(
            ChatClient.Builder chatClient
    ) {
        this.chatClient = chatClient.build();
    }

    @Tool(description = "Get available vacation days for a user by userId.")
    public ApiResponse getVacationDays(String userId) {
        return null;
        //TODO
    }

    @Tool(description = """
            Request leave for a user.
            Required fields: userId, fromDate (YYYY-MM-DD), toDate (YYYY-MM-DD), reason.
            If any of these fields are missing, inform the user exactly which field(s) are missing and do not proceed with the request.
            When all required values are provided, always confirm with the user before submitting the request.
            Show a summary of the extracted information (start date, end date, reason, userId) and ask: "Do you want to proceed?".
            Only proceed if user confirms with yes.
            """)
    public ApiResponse requestLeave() {
        return null;
        //TODO
    }


    @Tool(description = "Get leave request status for a user by userId.")
    public List<ApiResponse> getLeaveStatus(String userId) {
        return null;
        //TODO
    }

    @Tool(description = """
            Request a cash advance for a user.
            Required fields: userId, destinationCountry, city, managerId, amount.
            If any of these fields are missing, inform the user exactly which field(s) are missing and do not proceed with the request.
            When all fields are collected, confirm with user before proceeding.
            Show user the values and ask: "Do you want to continue?"
            Only proceed if user confirms with yes.
            """)
    public ApiResponse requestCashAdvance() {
        return null;
        //TODO
    }

    @Tool(description = "Get expense status for a user by userId.")
    public List<ApiResponse> getExpenseStatus(String userId) {
        return null;
        //TODO
    }

    @Tool(description = """
            Extract the total value from the built-in test image (test.jpg) using OCR via AI.
            Show the detected total to the user and ask for confirmation before saving.
            """)
    public ApiResponse extractSampleImageTotal() {
        String result = chatClient.prompt()
                .user(u -> {
                    u.text("Please extract the TOTAL value from this invoice image. Return only the amount.");
                    u.media(MimeTypeUtils.IMAGE_JPEG, sampleImage);
                })
                .call()
                .content();

        String message = String.format(
                "Totali i nxjerrë nga test.jpg është: %s",
                result.trim()
        );
        return new ApiResponse(message, "PENDING_CONFIRMATION");
    }
}
