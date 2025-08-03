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
        url = "http://localhost:8081",
        path = "/api/leaves"
)
public interface HrServiceClient {

    @GetMapping
    ResponseEntity<List<LeaveRequest>> getAllLeaves();

    @PostMapping
    ResponseEntity<LeaveRequest> createLeave(@RequestBody CreateLeaveRequestDto dto);

    @PutMapping("/{id}/status")
    ResponseEntity<String> updateLeaveStatus(@PathVariable("id") Integer id, @RequestBody Map<String, String> body);

    @GetMapping("/employee/{employeeId}/remaining")
    ResponseEntity<Map<String, Object>> getRemainingDays(@PathVariable("employeeId") Long employeeId);
}
