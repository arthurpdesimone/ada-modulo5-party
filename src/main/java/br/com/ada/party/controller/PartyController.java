package br.com.ada.party.controller;

import br.com.ada.party.exception.InvalidTypeException;
import br.com.ada.party.model.Party;
import br.com.ada.party.repository.DocumentRepository;
import br.com.ada.party.service.DocumentService;
import br.com.ada.party.service.PartyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/party")
@Slf4j
public class PartyController {
    @Autowired
    private PartyService partyService;

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Party> createParty(@Valid @RequestBody Party party) throws InvalidTypeException {
        log.info("Create Party [POST] {}",party.toString());
        documentService.saveDocument(party.getDocuments());
        partyService.saveParty(party);
        return ResponseEntity.ok(party);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Party>> getParty(@PathVariable Long id){
        Optional<Party> party = partyService.getParty(id);
        if(party.isPresent()){
            log.info("Get Party [GET] {}",party.toString());
            return ResponseEntity.ok(party);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteParty(@PathVariable Long id){
        Optional<Party> party = partyService.getParty(id);
        if(party.isPresent()){
            log.info("Delete Party [DELETE] {}",party.toString());
            partyService.deleteParty(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateParty(@PathVariable Long id,@Valid @RequestBody Party party){
        log.info("Update Party [PATCH] {}",party.toString());
        Party p = partyService.updateParty(id,party);
        return ResponseEntity.ok(p);
    }
}
