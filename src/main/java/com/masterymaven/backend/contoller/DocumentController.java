package com.masterymaven.backend.contoller;

import com.masterymaven.backend.dto.DocumentRequest;
import com.masterymaven.backend.dto.DocumentResponse;
import com.masterymaven.backend.entity.Document;
import com.masterymaven.backend.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("documents")
public class DocumentController {

    @Autowired
    private DocumentService docService;

    @PostMapping
    public ResponseEntity<Document> upload(@RequestBody DocumentRequest request){
        return ResponseEntity.ok(docService.save(request));

    }

    @GetMapping
    public ResponseEntity<List<DocumentResponse>> getAll(){
        return  ResponseEntity.ok(docService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<DocumentResponse>> searchAll(@RequestParam String query){
        return  ResponseEntity.ok(docService.searchAll(query));
    }


}
