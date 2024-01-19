package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateProposalDto;
import com.ismail.computerservice.model.Proposal;
import com.ismail.computerservice.service.ProposalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proposal")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping("/ user/create")
    public ResponseEntity<Proposal> createProposal(@RequestBody CreateProposalDto createProposalDto) {
        Proposal proposal = proposalService.createProposal(createProposalDto);
        return new ResponseEntity<>(proposal, HttpStatus.CREATED);
    }

    @GetMapping("/user/getall")
    public ResponseEntity<List<Proposal>> getAllProposals() {
        List<Proposal> proposals = proposalService.getAllProposals();
        return new ResponseEntity<>(proposals, HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteProposalById(@RequestParam Long id) {
        try{
            proposalService.deleteProposalById(id);
            return new ResponseEntity<>("Proposal deleted successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Failed to delete proposal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/updatestatus")
    public ResponseEntity<Proposal> updateProposalStatus(@RequestBody Long id) {
        try{
            Proposal proposal = proposalService.updateProposalStatus(id);
            return new ResponseEntity<>(proposal, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/getbyid")
    public ResponseEntity<Proposal> getProposalById(@RequestParam Long id) {
        Proposal proposal = proposalService.getProposalById(id);
        return new ResponseEntity<>(proposal, HttpStatus.OK);
    }
}
