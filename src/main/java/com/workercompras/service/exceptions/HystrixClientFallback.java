package com.workercompras.service.exceptions;

import com.workercompras.model.Endereco;
import com.workercompras.repository.CepRepository;


public class HystrixClientFallback implements CepRepository {

    @Override
    public Endereco buscarPorCep(String cep) {
        return null;

    }
}
