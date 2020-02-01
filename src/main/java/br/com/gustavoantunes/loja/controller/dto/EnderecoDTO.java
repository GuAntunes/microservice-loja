package br.com.gustavoantunes.loja.controller.dto;

public class EnderecoDTO {

	private String rua;
	
	private int numero;
	
	private String estado;

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
