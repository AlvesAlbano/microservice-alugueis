package org.microservice_aluguel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-aluguel")
    private Integer idAluguel;

    @Column(name = "id-usuario")
    private Integer idUsuario;

    @Column(name = "id-filme", unique = true)
    private Integer idFilme;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "inicio-aluguel")
    private LocalDate inicioAluguel;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "devolucao-aluguel")
    private LocalDate devolucaoAluguel;

    @Column(name = "valor-aluguel")
    private float valorAluguel;

    protected Aluguel() {
    }

    public Aluguel(Integer idUsuario, Integer idFilme, LocalDate inicioAluguel, LocalDate devolucaoAluguel, float valorAluguel) {
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdFilme() {
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

    public Integer getIdAluguel() {
        return idAluguel;
    }
}
