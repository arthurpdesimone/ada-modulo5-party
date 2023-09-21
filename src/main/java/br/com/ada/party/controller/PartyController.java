package br.com.ada.party.controller;

import br.com.ada.party.model.Party;
import br.com.ada.party.service.PartyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @PostMapping
    public ResponseEntity<Party> createParty(@Valid @RequestBody Party party){
        partyService.saveParty(party);
        return ResponseEntity.ok(party);
    }
}
