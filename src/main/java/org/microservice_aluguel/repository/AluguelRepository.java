package org.microservice_aluguel.repository;

import org.microservice_aluguel.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
    @Query("select a from Aluguel a where a.idFilme = ?1")
    List<Aluguel> findByIdFilme(@NonNull Integer idFilme);

    @Query("select a from Aluguel a where a.idUsuario = ?1")
    List<Aluguel> findByIdUsuario(@NonNull Integer idUsuario);
}
