package controller;
import java.util.List;
import model.PostoModel;

public class PostoController {
	public void salvarPosto(PostoModel posto) {
		posto.InserirPosto(posto);
    }
	
	public PostoModel buscarPostoPorCnpj(String cnpj) {
        return null;
    }
	
	public List<PostoModel> buscarPostos() {
        return null;
    }
}
