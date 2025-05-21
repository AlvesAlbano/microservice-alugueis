package org.microservice_turmas.dto;

import org.microservice_turmas.model.TurmaFundamental;

public class TurmaFundamentalDTO {

    private String turno;
    private byte serie;
    private char letra;

    public TurmaFundamentalDTO(String turno, byte serie, char letra) {
        this.turno = turno;
        this.serie = serie;
        this.letra = letra;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public byte getSerie() {
        return serie;
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

    public TurmaFundamental turmaFundamentalBuilder(){
        return new TurmaFundamental(
                turno.toUpperCase(),
                serie,
                Character.toUpperCase(letra)
        );
    }
}
