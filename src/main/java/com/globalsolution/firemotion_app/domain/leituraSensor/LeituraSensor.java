package com.globalsolution.firemotion_app.domain.leituraSensor;

import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "leituraSensor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


}
