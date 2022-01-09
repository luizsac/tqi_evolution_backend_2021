package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.LoanRequestDTO;
import com.tqi.evolution.tqievolution.dto.NewLoanRequestDTO;
import com.tqi.evolution.tqievolution.dto.LoanRequestDetailsDTO;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;
import com.tqi.evolution.tqievolution.service.LoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthenticatedUserController {

    private final LoanRequestService loanRequestService;

    @PostMapping("/request-loan")
    public ResponseEntity requestLoan(@RequestBody NewLoanRequestDTO newLoanRequestDTO) throws InvalidLoanRequestParametersException {
        return new ResponseEntity(loanRequestService.create(newLoanRequestDTO.toLoanRequest()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/loan-requests")
    public ResponseEntity getLoanRequests(@PathVariable long id) {
         var loanRequestDTOList = loanRequestService.getLoanRequestsByUserId(id)
                .stream()
                .map(loanRequest -> LoanRequestDTO.toDTO(loanRequest))
                .collect(Collectors.toList());

         return ResponseEntity.ok(loanRequestDTOList);
    }

    @GetMapping("/loan-request/{id}")
    public ResponseEntity getLoanRequest(@PathVariable long id) throws LoanRequestNotFoundException {
        var loanRequestDetailsDTO =
                LoanRequestDetailsDTO.toDTO(loanRequestService.getLoanRequestById(id));
        return ResponseEntity.ok(loanRequestDetailsDTO);
    }

}
