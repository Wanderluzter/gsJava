package com.fiap.gsJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gsJava.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
