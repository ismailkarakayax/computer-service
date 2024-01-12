package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateProposalDto;
import com.ismail.computerservice.model.Proposal;
import com.ismail.computerservice.service.ProposalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/proposal")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping("/create")
    public ResponseEntity<Proposal> createProposal(@RequestBody CreateProposalDto createProposalDto) {
        Proposal proposal = proposalService.createProposal(createProposalDto);
        return new ResponseEntity<>(proposal, HttpStatus.CREATED);
    }
}
