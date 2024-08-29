package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RelacaoGestorPorArquivo;

@Repository
public interface RelacaoGestorPorArquivoRepository extends JpaRepository<RelacaoGestorPorArquivo, Long> {

    List<RelacaoGestorPorArquivo> findByIdMonitoramentoContabil(Long idMonitoramentoContabil);
}