package org.microservice_turmas.dto;

import org.microservice_turmas.model.TurmaMedio;

public class TurmaMedioDTO {

    private String turno;
    private byte serie;
    private char letra;

    public TurmaMedioDTO(String turno, byte serie, char letra) {
        this.turno = turno;
        this.serie = serie;
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getTurno() {
        return turno;
    }

    public byte getSerie() {
        return serie;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSerie(byte serie) {
        this.serie = serie;
    }

    public TurmaMedio turmaMedioBuilder(){
        return new TurmaMedio(
                turno.toUpperCase(),
                serie,
                Character.toUpperCase(letra)
        );
    }
}
