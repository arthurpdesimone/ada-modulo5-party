package br.com.ada.party.service;

import br.com.ada.party.model.Party;
import br.com.ada.party.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    public Party saveParty(Party party){
        return partyRepository.save(party);
    }

    public Optional<Party> getParty(Long id){
        return partyRepository.findById(id);
    }
}
