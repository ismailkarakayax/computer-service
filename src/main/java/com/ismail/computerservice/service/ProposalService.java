package com.ismail.computerservice.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ismail.computerservice.dto.CreateProposalDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Proposal;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.ProductRepository;
import com.ismail.computerservice.repository.ProposalRepository;
import com.ismail.computerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ProposalService(ProposalRepository proposalRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.proposalRepository = proposalRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    public Proposal createProposal(CreateProposalDto createProposalDto) {
        try{
            Proposal newProposal= new Proposal();


            User user = userRepository.findById(createProposalDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

            Product product= productRepository.findById(createProposalDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Urun bulunamadı"));

            newProposal.setNote(createProposalDto.getNote());
            newProposal.setPrice(createProposalDto.getPrice());
            newProposal.setStatus(false);
            newProposal.setUser(user);
            newProposal.setProduct(product);

            return proposalRepository.save(newProposal);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create proposal: ",e);
        }


    }
}
