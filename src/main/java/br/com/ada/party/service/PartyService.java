package br.com.ada.party.service;

import br.com.ada.party.model.Party;
import br.com.ada.party.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    public Party saveParty(Party party){
        return partyRepository.save(party);
    }
}
