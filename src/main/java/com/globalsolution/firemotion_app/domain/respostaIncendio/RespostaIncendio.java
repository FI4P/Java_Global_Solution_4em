package com.globalsolution.firemotion_app.domain.respostaIncendio;


import com.globalsolution.firemotion_app.domain.entidadeResposta.EntidadeResposta;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "respostaIncendio")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaIncendio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private RespostaIncendioAcao acao;

    @Column(nullable = false)
    private RespostaIncendioStatus status;

    @ManyToOne
    @JoinColumn(name = "foco_incendio_id", nullable = false)
    private FocoIncendio focoIncendio;

    @ManyToOne
    @JoinColumn(name = "entidade_id", nullable = false)
    private EntidadeResposta entidadeResposta;


}
