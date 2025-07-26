package dev.arianit.orchestrartor.client;

import dev.arianit.orchestrartor.dto.hr.dto.CreateLeaveRequestDto;
import dev.arianit.orchestrartor.dto.hr.dto.RemainingDaysDto;
import dev.arianit.orchestrartor.dto.hr.enumeration.LeaveStatus;
import dev.arianit.orchestrartor.dto.hr.request.LeaveRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

@FeignClient(
        name = "hr-service",
        url = "${hr-service.url}",
        path = "/api/leaves"
)
public interface HrServiceClient {

    @GetMapping
    ResponseEntity<List<LeaveRequest>> getAllLeaves();

    @PostMapping
    ResponseEntity<LeaveRequest> createLeave(@RequestBody CreateLeaveRequestDto dto);

    @PutMapping("/{id}/status")
    ResponseEntity<String> updateLeaveStatus(@PathVariable("id") Integer id, @RequestBody LeaveStatus status);

    @GetMapping("/employee/{employeeId}/remaining")
    ResponseEntity<RemainingDaysDto> getRemainingDays(@PathVariable("employeeId") String employeeId);
}
