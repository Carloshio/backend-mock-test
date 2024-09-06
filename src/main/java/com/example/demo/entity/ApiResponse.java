package com.example.demo.entity;

import java.util.Map;

public class ApiResponse {
	private String entity;
    private int status;
    private Map<String, Object> metadata;

    // Construtores
    public ApiResponse(String entity, int status, Map<String, Object> metadata) {
        this.entity = entity;
        this.status = status;
        this.metadata = metadata;
    }

    // Getters e Setters
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
