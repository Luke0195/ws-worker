package com.workercompras.service.exceptions;

import com.workercompras.model.Endereco;
import com.workercompras.repository.CepRepository;
import lombok.SneakyThrows;

public class HystrixClientFallback implements CepRepository {

    @Override
    public Endereco buscarPorCep(String cep) {
        throw new Exception("Não foi possível encontrar o cep");

    }
}
