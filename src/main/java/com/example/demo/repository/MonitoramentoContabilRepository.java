package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MonitoramentoContabil;

@Repository
public interface MonitoramentoContabilRepository extends JpaRepository<MonitoramentoContabil, Long> {
	List<MonitoramentoContabil> findByJobName(String jobName);
    
    void deleteByJobName(String jobName);
    
    List<MonitoramentoContabil> findByJobNameAndRotina(String jobName, String rotina);
}
