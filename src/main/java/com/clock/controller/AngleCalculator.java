package com.clock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clock.entity.Clock;

@RestController
@RequestMapping("/rest/clock")
public class AngleCalculator {

	private Clock lista[][] = new Clock[13][60];
	
	@GetMapping(value = "/{hora}/{minuto}", produces = {"application/json"})
	public String getAnguloJson(@PathVariable int hora, @PathVariable int minuto) {
		
		Clock relogio = new Clock();
		
		if(this.lista[hora][minuto] == null) {
			relogio.setHora(hora);
			relogio.setMinuto(minuto);
			relogio.calcularAnguloPonteirosRelogio();
			this.lista[hora][minuto] = relogio;
			
			return this.lista[hora][minuto].toString();
		} else {
			System.out.println("Cache");
			relogio = this.lista[hora][minuto];
			
			return relogio.toString();
		}
		
	}
	
	//Considerando a hora que seja sem minutos para este caso 
	@GetMapping(value = "/{hora}", produces = {"application/json"})
	public String getAnguloJson(@PathVariable int hora) {
		
		Clock relogio = new Clock();
		
		if(this.lista[hora][0] == null) {
			relogio.setHora(hora);
			relogio.setMinuto(0);
			relogio.calcularAnguloPonteirosRelogio();
			this.lista[hora][0] = relogio;
			
			return this.lista[hora][0].toString();
		} else {
			System.out.println("Cache");
			relogio = this.lista[hora][0];
			
			return relogio.toString();
		}
		
	}
}
