package org.conectatrens.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comprovante")
public class ComprovanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer comprovante_id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date data_emissao = new Date();

    public String motivo_atraso;

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