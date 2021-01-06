package com.epam.prejap.tetris.game;

import java.time.Duration;
import java.time.Instant;

public class TimeCounter {

  private final Instant startTime;

  TimeCounter(Instant startTime) {
    this.startTime = startTime;
  }

  public static TimeCounter createStart() {
    return new TimeCounter(Instant.now());
  }

  public String totalDuration(){
    var timePassed = getTimePassed();
    return String.format("%02d:%02d:%02d",
        timePassed.toHours(),
        timePassed.toMinutesPart(),
        timePassed.toSecondsPart());
  }

  private Duration getTimePassed() {
    return Duration.between(startTime, Instant.now());
  }

}
