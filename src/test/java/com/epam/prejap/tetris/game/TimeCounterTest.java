package com.epam.prejap.tetris.game;

import static org.assertj.core.api.Assertions.assertThat;


import com.epam.prejap.tetris.game.TimeCounter;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.testng.annotations.Test;

public class TimeCounterTest {

   @Test
  public void givenFixedTimes_whenCompare_thenReturnsRemainingTime(){
     Instant fixedStartTime = Instant.parse("2021-01-06T02:19:30.00Z");
     Instant fixedEndTime = Instant.parse("2021-01-06T03:20:32.00Z");
     Clock fixedClock = Clock.fixed(fixedEndTime, ZoneId.systemDefault());
     TimeCounter timeCounter = new TimeCounter(fixedStartTime, fixedClock);

    String result = timeCounter.totalDuration();

    assertThat(result)
        .isEqualTo("01:01:02");
  }



}
