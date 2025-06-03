package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.Localizacao;
import com.fiap.gsJava.model.Previsao;
import com.fiap.gsJava.model.dto.PrevisaoDto;
import com.fiap.gsJava.repository.LocalizacaoRepository;
import com.fiap.gsJava.repository.PrevisaoRepository;

@Service
public class PrevisaoService {

    @Autowired
    private PrevisaoRepository repository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Previsao> getAll() {
        return repository.findAll();
    }

    public Previsao getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Previsão não encontrada"));
    }

    public Previsao create(PrevisaoDto dto) {
        Localizacao localizacao = localizacaoRepository.findById(dto.getIdLocalizacao())
                .orElseThrow(() -> new RuntimeException("Localização não encontrada"));

        Previsao previsao = new Previsao();
        previsao.setDataPrevisao(dto.getDataPrevisao());
        previsao.setTemperaturaMax(dto.getTemperaturaMax());
        previsao.setTemperaturaMin(dto.getTemperaturaMin());
        previsao.setUmidade(dto.getUmidade());
        previsao.setVelocidadeVento(dto.getVelocidadeVento());
        previsao.setIndiceUv(dto.getIndiceUv());
        previsao.setQualidadeAr(dto.getQualidadeAr());
        previsao.setLocalizacao(localizacao);

        return repository.save(previsao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
