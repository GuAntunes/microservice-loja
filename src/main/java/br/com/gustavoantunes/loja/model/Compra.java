package br.com.gustavoantunes.loja.model;

public class Compra {

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDestino;

	public Long getPedidoId() {
		return pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

}
