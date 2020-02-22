package br.com.gustavoantunes.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gustavoantunes.loja.controller.dto.InfoEntregaDTO;
import br.com.gustavoantunes.loja.controller.dto.VoucherDTO;

@FeignClient("transportador")
public interface TransportadorClient {
	
	@PostMapping("/entrega")
	public VoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO pedidoDTO);
}
