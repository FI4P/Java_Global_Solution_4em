package com.globalsolution.firemotion_app.domain.localizacao;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "localizacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 10, scale = 6)
    private BigDecimal longitude;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensores =  new ArrayList<>();

    @OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FocoIncendio> focosIncendios = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        this.sensores.add(sensor);
        sensor.setLocalizacao(this);
    }

    public void addFocoIncendio(FocoIncendio focoIncendio){
        focosIncendios.add((focoIncendio));
        focoIncendio.setLocalizacao(this);
    }


}
