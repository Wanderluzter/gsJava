package com.fiap.gsJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.gsJava.model.Previsao;

@Repository
public interface PrevisaoRepository extends JpaRepository<Previsao, Long> {

}
