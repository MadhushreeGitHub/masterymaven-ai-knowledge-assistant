package com.masterymaven.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentResponse {

    private String id;
    private String name;
    private String Content;
    private LocalDateTime createdAt;
}
