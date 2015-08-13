package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dominio.UsuarioLogado;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {
	
	private final UsuarioLogado usuarioLogado;
	private final Result result;
	
	public LoginController(UsuarioLogado usuarioLogado, Result result){	
		this.usuarioLogado = usuarioLogado;		
		this.result = result;
	}
	
	@Path("/entrar")
	public void formulario(){}
	
	public void loga(String login, String senha){
		System.out.println("Usuario: "+login+"Senha: "+senha);
		if(login.equals("caelum") && senha.equals("vraptor")){
			this.usuarioLogado.setLogin(login);
			result.redirectTo(ProdutoController.class).lista();
		}else{
			result.redirectTo(LoginController.class).formulario();
		}
	}
	
	public void exibe(){
		result.include("usuario", usuarioLogado.getLogin());
	}

}
