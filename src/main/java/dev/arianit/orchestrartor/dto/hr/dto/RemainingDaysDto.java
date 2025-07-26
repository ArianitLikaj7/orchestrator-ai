package dev.arianit.orchestrartor.dto.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemainingDaysDto {
    private int annualLeave;
    private int sickLeave;
    private int otherLeave;
}
