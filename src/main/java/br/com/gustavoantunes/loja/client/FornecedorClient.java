package br.com.gustavoantunes.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoantunes.loja.controller.dto.InfoFornecedorDTO;
import br.com.gustavoantunes.loja.controller.dto.InfoPedidoDTO;
import br.com.gustavoantunes.loja.controller.dto.ItemDaCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
	
}
