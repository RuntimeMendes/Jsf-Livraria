package br.com.ricardo.livraria.bean;



import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ricardo.livraria.dao.DAO;
import br.com.ricardo.livraria.modelo.Autor;
import br.com.ricardo.livraria.modelo.Livro;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutores(){
		
		return new DAO<Autor>(Autor.class).listaTodos();
		
	}
	

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve ter pelo menos um Autor.");
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
	}

}
