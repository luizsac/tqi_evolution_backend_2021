package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.LoanRequestDTO;
import com.tqi.evolution.tqievolution.dto.NewLoanRequestDTO;
import com.tqi.evolution.tqievolution.dto.LoanRequestDetailsDTO;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.service.LoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthenticatedUserController {

    private final LoanRequestService loanRequestService;

    @PostMapping("/request-loan")
    public ResponseEntity<LoanRequestDTO> requestLoan
            (@RequestHeader("Authorization") String token, @RequestBody NewLoanRequestDTO newLoanRequestDTO)
            throws InvalidLoanRequestParametersException, UserNotFoundException {
        var loanRequestDTO = LoanRequestDTO.toDTO(loanRequestService.create(token, newLoanRequestDTO.toLoanRequest()));
        return new ResponseEntity<>(loanRequestDTO, HttpStatus.CREATED);
    }

    @GetMapping("/loan-requests")
    public ResponseEntity<List<LoanRequestDTO>> getLoanRequests(@RequestHeader("Authorization") String token) {
        var loanRequestDTOList = loanRequestService.getLoanRequestsByUsername(token)
                .stream()
                .map(loanRequest -> LoanRequestDTO.toDTO(loanRequest))
                .collect(Collectors.toList());
        return new ResponseEntity<>(loanRequestDTOList, HttpStatus.OK);
    }

    @GetMapping("/loan-request/{id}")
    public ResponseEntity<LoanRequestDetailsDTO> getLoanRequest(@PathVariable long id) throws LoanRequestNotFoundException {
        var loanRequestDetailsDTO =
                LoanRequestDetailsDTO.toDTO(loanRequestService.getLoanRequestById(id));
        return new ResponseEntity<>(loanRequestDetailsDTO, HttpStatus.OK);
    }

}
