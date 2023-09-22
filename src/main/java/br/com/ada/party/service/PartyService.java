package br.com.ada.party.service;

import br.com.ada.party.model.Party;
import br.com.ada.party.repository.PartyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    public void deleteParty(Long id){
        partyRepository.deleteById(id);
    }

    public Party updateParty(Long id, Party p){
        Optional<Party> party = getParty(id);
        if(party.isPresent()){
            party.get().setDate(p.getDate());
            party.get().setName(p.getName());
            return partyRepository.save(party.get());
        }else{
            throw new EntityNotFoundException();
        }
    }
}
