package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.LoanRequestDetailsDTO;
import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.service.LoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthenticatedUserController {

    private final LoanRequestService loanRequestService;

    @PostMapping("/request-loan")
    public ResponseEntity requestLoan(@RequestBody LoanRequest loanRequest) throws InvalidLoanRequestParametersException {
        return new ResponseEntity(loanRequestService.create(loanRequest), HttpStatus.CREATED);
    }

    @GetMapping("/loan-requests")
    public ResponseEntity getLoanRequests() {
        return null;
    }

    @GetMapping("/loan-request/{id}")
    public ResponseEntity getLoanRequest(@PathVariable long id) {
        var loanRequestDetailsDTO =
                LoanRequestDetailsDTO.toDTO(loanRequestService.getLoanRequestById(id));
        return ResponseEntity.ok(loanRequestDetailsDTO);
    }

}
