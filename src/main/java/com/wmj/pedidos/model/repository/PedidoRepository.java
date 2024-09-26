package com.wmj.pedidos.model.repository;

import com.wmj.pedidos.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<List<PedidoEntity>> findByClienteId(Long id);
}
