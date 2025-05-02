package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.conectatrens.entity.EstacaoEntity;
import org.conectatrens.entity.LinhaEntity;
import org.conectatrens.entity.ReclamacaoEntity;
import org.conectatrens.entity.UsuarioEntity;
import org.conectatrens.repository.EstacaoRepository;
import org.conectatrens.repository.LinhaRepository;
import org.conectatrens.repository.ReclamacaoRepository;
import org.conectatrens.repository.UsuarioRepository;

import java.util.List;

@ApplicationScoped
public class ReclamacaoService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    LinhaRepository linhaRepository;

    @Inject
    EstacaoRepository estacaoRepository;

    @Inject
    ReclamacaoRepository reclamacaoRepository;

    public ReclamacaoEntity findById(Long id) {
        return reclamacaoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Reclamação não encontrada"));
    }

    public List<ReclamacaoEntity> listAll() {
        return reclamacaoRepository.findAll().list();
    }

   
   

    @Transactional
    public ReclamacaoEntity createReclamacao(ReclamacaoEntity reclamacao) {
        // Validação dos IDs
        if (reclamacao.usuario_id == null || reclamacao.linha_id == null || reclamacao.estacao_id == null) {
            throw new IllegalArgumentException("IDs de usuário, linha e estação são obrigatórios");
        }

        // Carrega as entidades relacionadas
        UsuarioEntity usuario = usuarioRepository.findById(reclamacao.usuario_id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado com ID: " + reclamacao.usuario_id);
        }

        LinhaEntity linha = linhaRepository.findById(reclamacao.linha_id);
        if (linha == null) {
            throw new NotFoundException("Linha não encontrada com ID: " + reclamacao.linha_id);
        }

        EstacaoEntity estacao = estacaoRepository.findById(reclamacao.estacao_id);
        if (estacao == null) {
            throw new NotFoundException("Estação não encontrada com ID: " + reclamacao.estacao_id);
        }

        // Associa as entidades (apenas para consulta)
        reclamacao.usuario = usuario;
        reclamacao.linha = linha;
        reclamacao.estacao = estacao;

        reclamacaoRepository.persist(reclamacao);
        return reclamacao;
    }
}