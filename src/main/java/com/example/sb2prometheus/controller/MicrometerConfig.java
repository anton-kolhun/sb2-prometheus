package com.example.sb2prometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {

  public MicrometerConfig(MeterRegistry meterRegistry) {
    //List<String> list = new ArrayList<>(4);
    //Gauge.builder("my_test", list, value -> list.size())
    Gauge.builder("my_gauge", () -> 1)
        .tag("cust_id", "1")
        .register(meterRegistry);

//    Counter counter = Counter
//        .builder("my_counter")
//        .tag("cust_id", "1")
//        .description("indicates instance count of the object")
//        .register(meterRegistry);

  /*  LongTaskTimer longTaskTimer = LongTaskTimer
        .builder("my_timer")
        .tag("cust_id", "1")
        .register(meterRegistry);*/
  }

}
