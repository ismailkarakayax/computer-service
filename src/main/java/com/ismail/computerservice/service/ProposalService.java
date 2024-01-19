package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateProposalDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Proposal;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.ProductRepository;
import com.ismail.computerservice.repository.ProposalRepository;
import com.ismail.computerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
            User user = userRepository.findById(createProposalDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
            Product product= productRepository.findById(createProposalDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Urun bulunamadı"));
            Proposal newProposal = createProposalEntity(createProposalDto,user,product);

            return proposalRepository.save(newProposal);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create proposal: ",e);
        }
    }

    public List<Proposal> getProposalByUserId(Long id){
        try{
            return proposalRepository.findAllByUserId(id);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to get proposal by user id: ",e);
        }
    }

    public List<Proposal> getAllProposals(){
        return proposalRepository.findAll();
    }

    public Proposal getProposalById(Long id){
        return proposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teklif bulunamadı"));
    }

    public Proposal updateProposalStatus(Long id){
        Proposal proposal = proposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teklif bulunamadı"));
        proposal.setStatus(true);
        return proposalRepository.save(proposal);
    }

    public Proposal deleteProposalById(Long id){
        proposalRepository.deleteById(id);
        return null;
    }

    public Proposal createProposalEntity(CreateProposalDto createProposalDto, User user, Product product){
        Proposal newProposal= new Proposal();
        newProposal.setNote(createProposalDto.getNote());
        newProposal.setPrice(createProposalDto.getPrice());
        newProposal.setStatus(false);
        newProposal.setUser(user);
        newProposal.setProduct(product);
        return newProposal;
    }
}
