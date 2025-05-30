package com.globalsolution.firemotion_app.domain.entidadeResposta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "entidadeResposta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadeResposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntidadeRespostaTipo tipo;

    @Column(nullable = false)
    private String contato;

}
