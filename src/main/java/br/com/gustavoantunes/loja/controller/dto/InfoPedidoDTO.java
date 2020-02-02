package br.com.gustavoantunes.loja.controller.dto;

public class InfoPedidoDTO {

	private Long id;
	private Integer tempoDePreparo;

	public Long getId() {
		return id;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

}
