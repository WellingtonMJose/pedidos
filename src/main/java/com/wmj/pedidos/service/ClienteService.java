package com.wmj.pedidos.service;

import com.wmj.pedidos.model.dto.ClienteDTO;
import com.wmj.pedidos.model.entity.Cliente;
import com.wmj.pedidos.model.exception.ObjectNotFoundException;
import com.wmj.pedidos.model.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente find(Long id) {

        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id ));
    }

    @Transactional
    public Cliente insert(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente = clienteRepository.save(cliente);
        return cliente;
    }

}
