package br.com.ada.party.service;

import br.com.ada.party.exception.InvalidTypeException;
import br.com.ada.party.model.Document;
import br.com.ada.party.model.Party;
import br.com.ada.party.model.PartyType;
import br.com.ada.party.repository.PartyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    public Party saveParty(Party party) throws InvalidTypeException {
        switch (party.getPartyType()) {
            case CLIENTE, FUNCIONÁRIO -> {
                if (isPhysicalPerson(party)) {
                    return partyRepository.save(party);
                }
            }
            case FORNECEDOR -> {
                if (isCompany(party)) {
                    return partyRepository.save(party);
                }
            }
        }
        throw new InvalidTypeException();
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

    private boolean isPhysicalPerson(Party party){
        Pattern p = Pattern.compile("CPF|RG");
        boolean found = false;
        for (Document s : party.getDocuments()) {
            if (p.matcher(s.getType().name()).find()) {
                found = true;
                break;
            }
        }
        return found;
    }

    private boolean isCompany(Party party){
        Pattern p = Pattern.compile("CNPJ");
        boolean found = false;
        for (Document s : party.getDocuments()) {
            if (p.matcher(s.getType().name()).find()) {
                found = true;
                break;
            }
        }
        return found;
    }

}
