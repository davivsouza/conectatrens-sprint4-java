package org.conectatrens.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer usuario_id;

    public String nome;
    public String senha;
    public String email;
    public String telefone;

}