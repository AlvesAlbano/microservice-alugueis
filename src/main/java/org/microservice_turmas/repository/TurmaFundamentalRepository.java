package org.microservice_turmas.repository;

import org.microservice_turmas.model.TurmaFundamental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface TurmaFundamentalRepository extends JpaRepository<TurmaFundamental
        ,Integer> {
    @Query("select t from TurmaFundamental t where t.letra = ?1")
    List<TurmaFundamental> findByLetra(@NonNull char letra);

    @Query("select t from TurmaFundamental t where t.turno = ?1")
    List<TurmaFundamental> findByTurno(@NonNull String turno);
}
