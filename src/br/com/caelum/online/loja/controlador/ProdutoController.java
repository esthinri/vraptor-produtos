package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class ProdutoController {
	
	private Result result;
	private final RepositorioDeProdutos produtos;
	private final Validator validator;
	private ProdutoDao dao;

	public ProdutoController(Result result, RepositorioDeProdutos produtos, Validator validator, ProdutoDao dao) {
		this.result = result;
		this.produtos = produtos;
		this.validator = validator;
		this.dao = dao;
	}

	public List<Produto> lista() {
		return new ProdutoDao().pegaTodos();
	}

	public void formulario() {
	}

	@Post
	public void adiciona(final Produto produto) {
		 validator.checking(new Validations(){{
		        // o preço deve ser maior que 0.1
		        that(produto.getPreco() > 0.1,"erro", "produto.preco.invalido");
		       }});
		 validator.checking(new Validations(){{
			that(!produto.getDescricao().isEmpty(),"erro", "produto.desc.vazia") ;
		 }});
		 validator.checking(new Validations(){{
			 that(produto.getNome().length() > 3 && produto.getNome().length() < 100,"erro","produto.nome.tamanho");
		 }});
	    validator.onErrorUsePageOf(ProdutoController.class).formulario();
		
	    produtos.salva(produto);
        result.include("mensagem", "Novo produto adicionado com sucesso!");
        result.redirectTo(ProdutoController.class).lista();
	}

	@Path("/produto/{id}")
	public Produto exibe(long id) {
		return new ProdutoDao().pegaPorId(id);
	}
	
	public void remove(Produto produto) {
	    produtos.remove(produto);
	    result.nothing();
	}

}
