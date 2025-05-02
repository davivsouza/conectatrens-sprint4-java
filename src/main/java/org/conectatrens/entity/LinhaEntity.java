package org.conectatrens.entity;

import jakarta.persistence.*;


@Entity
@Table(name="linha")
public class LinhaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer linha_id;


    public String nome;
    public String cor;

}