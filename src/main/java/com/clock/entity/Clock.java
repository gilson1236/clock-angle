package com.clock.entity;

public class Clock {
 
	private static final int ANGULO_POR_HORA = 30;
	private static final int ANGULO_POR_MINUTO = 6;
	
	private int hora;
	private int minuto;
	private int angulo;
	
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
	private int getAngulo() {
		return this.angulo;
	}
	
	public int calcularAnguloPonteirosRelogio() {
		
		this.angulo = Math.abs(getHoraAngulo(this.hora) - getMinutoAngulo(this.minuto));
		if(this.angulo > 180) {
			this.angulo = 360 - this.angulo;
		}
		return this.angulo;
	}

	private int getMinutoAngulo(int minuto) {
		return minuto * ANGULO_POR_MINUTO;
	}

	private int getHoraAngulo(int hora) {
		return hora * ANGULO_POR_HORA;
	}
	
	@Override
	public String toString() {
		return "{\"angulo\":" + this.getAngulo();
	}
}
