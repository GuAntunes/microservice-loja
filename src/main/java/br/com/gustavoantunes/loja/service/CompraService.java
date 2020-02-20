package br.com.gustavoantunes.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.gustavoantunes.loja.client.FornecedorClient;
import br.com.gustavoantunes.loja.controller.dto.CompraDTO;
import br.com.gustavoantunes.loja.controller.dto.InfoFornecedorDTO;
import br.com.gustavoantunes.loja.controller.dto.InfoPedidoDTO;
import br.com.gustavoantunes.loja.model.Compra;
import br.com.gustavoantunes.loja.repository.CompraRepository;

@Service
public class CompraService {
//
//	@Autowired
//	private RestTemplate client;
	
	@Autowired
	private CompraRepository CompraRepository;

	@Autowired
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private FornecedorClient fornecedorClient;

	@HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPool")
	public Compra realizaCompra(CompraDTO compra) {

//		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
//				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
//				InfoFornecedorDTO.class);

		String estado = compra.getEndereco().getEstado();

		LOG.info("Buscando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

		LOG.info("Realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

		System.out.println(info.getEndereco());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		CompraRepository.save(compraSalva);
		
		return compraSalva;
	}

	public Compra realizaCompraFallback(CompraDTO compra) {
		Compra compraFallBack = new Compra();
		compraFallBack.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallBack;
	}

	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Compra getById(Long id) {
		return CompraRepository.findById(id).orElse(new Compra());
	}

}
