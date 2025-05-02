package org.conectatrens.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reclamacao")
public class ReclamacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer reclamacao_id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date data_reclamacao = new Date();
    
    public String tipo;
    public String descricao;
    public String status = "Em Análise";

    public Long usuario_id;

    public Long linha_id;

    public Long estacao_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    public UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "linha_id", insertable = false, updatable = false)
    public LinhaEntity linha;

    @ManyToOne
    @JoinColumn(name = "estacao_id", insertable = false, updatable = false)
    public EstacaoEntity estacao;
}