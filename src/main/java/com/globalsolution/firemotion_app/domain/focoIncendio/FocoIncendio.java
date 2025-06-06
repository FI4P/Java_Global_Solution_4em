package com.globalsolution.firemotion_app.domain.focoIncendio;


import com.globalsolution.firemotion_app.domain.alerta.Alerta;
import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "focoIncendio")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FocoIncendio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FocoIncendioIntensidade intensidade;

    @Column(nullable = false)
    private String origem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FocoIncendioStatus status;

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    @OneToMany(mappedBy = "focoIncendio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas;

    @OneToMany(mappedBy = "focoIncendio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespostaIncendio> respostasIncendios;

    public void addAlerta(Alerta alerta) {
        alertas.add(alerta);
        alerta.setFocoIncendio(this);
    }

    public void addRespostaIncendio(RespostaIncendio respostaIncendio){
        respostasIncendios.add(respostaIncendio);
        respostaIncendio.setFocoIncendio(this);
    }

}
