package dev.arianit.orchestrartor.dto.hr.dto;

import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLeaveRequestDto {
    @NotBlank(message = "employeeId is required")
    private Long employeeId = 123L;

    @NotNull(message = "type is required")
    private LeaveType type;

    @NotNull(message = "startDate is required")
    private LocalDate startDate;

    @NotNull(message = "endDate is required")
    private LocalDate endDate;
}
