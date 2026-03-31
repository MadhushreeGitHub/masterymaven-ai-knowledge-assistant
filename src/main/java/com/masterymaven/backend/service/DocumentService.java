package com.masterymaven.backend.service;

import com.masterymaven.backend.dto.DocumentRequest;
import com.masterymaven.backend.dto.DocumentResponse;
import com.masterymaven.backend.entity.Document;
import com.masterymaven.backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    public Document save(DocumentRequest documentRequest){
        Document doc = new Document();
        doc.setName(documentRequest.getName());
        doc.setContent(documentRequest.getContent());
        doc.setCreatedAt(LocalDateTime.now());
        return repository.save(doc);
    }

    public List<DocumentResponse> getAll(){
        List<Document> documentList = repository.findAll();
        return documentList.stream().map(document -> {
            DocumentResponse documentResponse = new DocumentResponse();
            documentResponse.setName(document.getName());
            documentResponse.setId(String.valueOf(document.getId()));
            documentResponse.setContent(document.getContent());
            documentResponse.setCreatedAt(document.getCreatedAt());
            return documentResponse;
        }).toList();
    }

    public List<DocumentResponse> searchAll(String query){
        List<Document> documentList = repository.search(query);
        return documentList.stream().map(document -> {
            DocumentResponse documentResponse = new DocumentResponse();
            documentResponse.setName(document.getName());
            documentResponse.setId(String.valueOf(document.getId()));
            documentResponse.setContent(document.getContent());
            documentResponse.setCreatedAt(document.getCreatedAt());
            return documentResponse;
        }).toList();
    }
}
