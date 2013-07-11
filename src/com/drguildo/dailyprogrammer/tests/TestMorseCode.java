package com.drguildo.dailyprogrammer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.drguildo.dailyprogrammer.MorseCode;

public class TestMorseCode {
  MorseCode mc;

  @Test
  public void equivalence() {
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    assertEquals(mc.fromMorse(mc.toMorse(letters)), letters);
  }

  @Before
  public void setUp() throws Exception {
    mc = new MorseCode();
  }

  @Test
  public void testBlank() {
    assertEquals(mc.fromMorse(""), "");
    assertEquals(mc.toMorse(""), "");
  }
}
