package org.microservice_turmas.model;

import jakarta.persistence.*;

@Entity
public class TurmaFundamental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Integer idTurma;

    @Column(name = "turno_turma")
    private String turno;

    @Column(name = "serie_turma")
    private byte serie;

    @Column(name = "letra_turma")
    private char letra;

    public TurmaFundamental(){}

    public TurmaFundamental(String turno, byte serie, char letra) {
        this.turno = turno;
        this.serie = serie;
        this.letra = letra;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSerie(byte serie) {
        this.serie = serie;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public String getTurno() {
        return turno;
    }

    public byte getSerie() {
        return serie;
    }
}