package com.workercompras.service;

import com.workercompras.config.FeignConfiguration;
import com.workercompras.model.Endereco;
import com.workercompras.repository.CepRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Slf4j
@Service

public class CepService {

    @Autowired
    private  FeignConfiguration feignConfiguration;
    @Autowired
    private  CepRepository repository;


    public Endereco buscarCep(String cep){
        Endereco  endereco = repository.buscarPorCep(cep);
        return  endereco;
    }
}
