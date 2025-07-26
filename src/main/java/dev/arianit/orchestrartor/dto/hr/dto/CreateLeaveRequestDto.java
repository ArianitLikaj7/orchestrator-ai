package dev.arianit.orchestrartor.dto.hr.dto;

import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveType;
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
    private String employeeId;
    private LeaveType type;
    private LocalDate startDate;
    private LocalDate endDate;
}
