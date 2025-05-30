package com.globalsolution.firemotion_app.repository.sensor;

import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
