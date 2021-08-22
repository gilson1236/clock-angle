package com.clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.clock.controller.AngleCalculator;
import com.clock.entity.Clock;

public class ClockTest {

	static Clock clock;
	static AngleCalculator angleCalculator;
	
	@BeforeAll
	public static void setup() {
		clock = new Clock();
		angleCalculator = new AngleCalculator();
	}
	
	@Test
	public void deveRetornarNoventaGrausAoInformarTresHoras() {
		assertEquals("{\"angulo\":90", angleCalculator.getAnguloJson(3));
	}
	
	
	@Test
	public void deveRetornarCentoEOitentaGrausAoInformarSeisHoras() {
		assertEquals("{\"angulo\":180", angleCalculator.getAnguloJson(6));
	}
	
	@Test
	public void deveRetornarNoventaGrausAoInformarNoveHoras() {
		assertEquals("{\"angulo\":90", angleCalculator.getAnguloJson(9));
	}
	
	@Test
	public void deveRetornarZeroGrauAoInformarDozeHoras() {
		assertEquals("{\"angulo\":0", angleCalculator.getAnguloJson(12));
	}
	
	@Test
	public void deveRetornarCentoESetentaEQuatroGrausAoInformarDozeHorasEVinteENoveMinutos() {
		assertEquals("{\"angulo\":174", angleCalculator.getAnguloJson(12, 29));
	}
	
	@Test
	public void deveRetornarCentoESetentaEQuatroGrausInformarDozeHorasETrintaEUmMinutos() {
		assertEquals("{\"angulo\":174", angleCalculator.getAnguloJson(12, 31));
	}
}
