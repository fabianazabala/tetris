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

  public String getTotalDuration(){
    return Duration.between(startTime, Instant.now()).toString()
        .substring(2)
        .replaceAll("(\\d[HMS])(?!$)", "$1 ")
        .toLowerCase();
  }

}
