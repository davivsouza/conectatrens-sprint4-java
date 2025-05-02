package org.conectatrens.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "linha_estacao")
public class LinhaEstacaoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public Integer linha_estacao_id;

  public Long linha_id;

  public Long estacao_id;

  public Integer ordem_na_linha;

  @ManyToOne
  @JoinColumn(name = "linha_id", insertable = false, updatable = false)
  public LinhaEntity linha;

  @ManyToOne
  @JoinColumn(name = "estacao_id", insertable = false, updatable = false)
  public EstacaoEntity estacao;

}