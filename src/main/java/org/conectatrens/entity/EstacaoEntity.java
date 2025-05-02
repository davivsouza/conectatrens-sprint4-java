package org.conectatrens.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estacao")
public class EstacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer estacao_id;

    public String nome;
    public String localizacao;
    public String horario_funcionamento;
}