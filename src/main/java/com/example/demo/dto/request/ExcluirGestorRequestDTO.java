package com.example.demo.dto.request;

import java.util.List;

import com.example.demo.entity.GestorDTO;

public class ExcluirGestorRequestDTO {
	private List<GestorDTO> gestorList;

    // Getters e Setters
    public List<GestorDTO> getGestorList() {
        return gestorList;
    }

    public void setGestorList(List<GestorDTO> gestorList) {
        this.gestorList = gestorList;
    }
}
