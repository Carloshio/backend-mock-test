package com.example.demo.service;

import com.example.demo.entity.MonitoramentoContabil;
import com.example.demo.repository.MonitoramentoContabilRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoramentoContabilService {

    @Autowired
    private MonitoramentoContabilRepository repository;
      

    public MonitoramentoContabil save(MonitoramentoContabil monitoramentoContabil) {
        return repository.save(monitoramentoContabil);
    }

    public List<MonitoramentoContabil> findAll() {
        return repository.findAll();
    }

    public List<MonitoramentoContabil> findByJobName(String jobName) {
        return repository.findByJobName(jobName);
    }

    @Transactional
    public ResponseEntity<Void> deleteByJobName(String jobName) {
        repository.deleteByJobName(jobName);
        return ResponseEntity.noContent().build();
    }
    
    public List<MonitoramentoContabil> findByJobNameAndRotina(String jobName, String rotina) {
        return repository.findByJobNameAndRotina(jobName, rotina);
    }
}
