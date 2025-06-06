package org.microservice_aluguel.dto;

import org.microservice_aluguel.model.Aluguel;

import java.time.LocalDate;


public class AluguelDTO {

    private Integer idUsuario;
    private Integer idFilme;
    private LocalDate inicioAluguel;
    private LocalDate devolucaoAluguel;
    private float valorAluguel;

    public AluguelDTO(Integer idUsuario, Integer idFilme, LocalDate inicioAluguel, LocalDate devolucaoAluguel, float valorAluguel) {
        this.idUsuario = idUsuario;
        this.idFilme = idFilme;
        this.inicioAluguel = inicioAluguel;
        this.devolucaoAluguel = devolucaoAluguel;
        this.valorAluguel = valorAluguel;
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public LocalDate getInicioAluguel() {
        return inicioAluguel;
    }

    public void setInicioAluguel(LocalDate inicioAluguel) {
        this.inicioAluguel = inicioAluguel;
    }

    public LocalDate getDevolucaoAluguel() {
        return devolucaoAluguel;
    }

    public void setDevolucaoAluguel(LocalDate devolucaoAluguel) {
        this.devolucaoAluguel = devolucaoAluguel;
    }

    public Aluguel aluguelBuilder() {
        return new Aluguel(
                idUsuario,
                idFilme,
                inicioAluguel,
                devolucaoAluguel,
                valorAluguel
        );
    }

    @Override
    public String toString() {
        return "AluguelDTO{" +
                "idUsuario=" + idUsuario +
                ", idFilme=" + idFilme +
                ", inicioAluguel=" + inicioAluguel +
                ", devolucaoAluguel=" + devolucaoAluguel +
                '}';
    }
}
