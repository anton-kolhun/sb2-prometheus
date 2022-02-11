package com.example.sb2prometheus.controller;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

  @GetMapping
  public String index() {
    Random r = new Random();
    Metrics.counter("my_counter", "cust_id", String.valueOf(r.nextInt(5))).increment();

    Tag tag = Tag.of("cust_id", String.valueOf(r.nextInt(5)));
    Metrics.gauge("my_gauge", Collections.singletonList(tag), 1);

    Timer t = Metrics.timer("my_timer", "cust_id", String.valueOf(r.nextInt(5)));
    t.record(30, TimeUnit.MILLISECONDS);
    return "test";
  }

}
