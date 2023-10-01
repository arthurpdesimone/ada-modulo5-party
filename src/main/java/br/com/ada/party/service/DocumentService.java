package br.com.ada.party.service;

import br.com.ada.party.model.Document;
import br.com.ada.party.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public void saveDocument(List<Document> document){
        documentRepository.saveAll(document);
    }
}
