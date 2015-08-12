package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

@Resource
public class ProdutoController {

	private final ProdutoDao produtos;

	public ProdutoController() {
		this.produtos = new ProdutoDao();
	}

	public List<Produto> lista() {
		return new ProdutoDao().pegaTodos();
	}

	public void formulario() {
	}

	@Post
	public void adiciona(Produto produto) {
		produtos.salva(produto);
	}

	@Path("/produto/{id}")
	public Produto exibe(long id) {
		return new ProdutoDao().pegaPorId(id);
	}

}
