package com.globalsolution.firemotion_app.domain.sensor;


import com.globalsolution.firemotion_app.domain.alerta.Alerta;
import com.globalsolution.firemotion_app.domain.leituraSensor.LeituraSensor;
import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Sensor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SensorTipo tipo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "localizacao_id", nullable = false)
    private Localizacao localizacao;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas = new ArrayList<>();

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeituraSensor> leituras = new ArrayList<>();


}
