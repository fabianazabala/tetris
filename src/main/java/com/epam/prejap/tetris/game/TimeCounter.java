package com.epam.prejap.tetris.game;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

/**
 * TimeCounter class calculates the elapsed time in every cycle of the game using the hh:mm:ss format.
 * @author Fabiana Zabala
 */
public class TimeCounter {

  private final Instant startTime;
  private final Clock clock;

  TimeCounter(Instant startTime,
              Clock clock) {
    this.startTime = startTime;
    this.clock = clock;
  }

  /**
   * Creates a time counter initializing {@link TimeCounter#startTime} to current time.
   * @return TimeCounter
   */
  public static TimeCounter createStart() {
    Clock clock = Clock.systemUTC();
    return new TimeCounter(Instant.now(clock), clock);
  }

  /**
   * Returns time passed between {@link TimeCounter#startTime} and current time.
   * @return String in format hh:mm:ss
   */
  public String totalDuration(){
    var timePassed = getTimePassed();
    return String.format("%02d:%02d:%02d",
        timePassed.toHours(),
        timePassed.toMinutesPart(),
        timePassed.toSecondsPart());
  }

  private Duration getTimePassed() {
    return Duration.between(startTime, Instant.now(clock));
  }

}
