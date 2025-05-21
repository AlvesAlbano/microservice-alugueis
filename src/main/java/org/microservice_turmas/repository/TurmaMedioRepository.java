package org.microservice_turmas.repository;

import org.microservice_turmas.model.TurmaMedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface TurmaMedioRepository extends JpaRepository<TurmaMedio,Integer> {
    @Query("select t from TurmaMedio t where t.letra = ?1")
    List<TurmaMedio> findByLetra(@NonNull char letra);

    @Query("select t from TurmaMedio t where t.turno = ?1")
    List<TurmaMedio> findByTurno(@NonNull String turno);
}
