import java.util.*;

public class CatálogoLivros implements Iterable<Livro> {
    private List<Livro> livros = new ArrayList<>();

    public static final int POSICAO_NAO_EXISTENTE = -1;

    public int tamanho()
    {
        return livros.size();
    }

    public boolean adicionarLivro( Livro livro)
    {
        return livros.add(livro);
    }

    public boolean removerLivro( Livro livro)
    {
        return livros.remove(livro);
    }

    public boolean substituir(Livro livroAntigo, Livro livroNovo)
    {
        int posiçãoLivroAntigo = livros.indexOf(livroAntigo);

        if ( posiçãoLivroAntigo == POSICAO_NAO_EXISTENTE ) return false;

        livros.set( posiçãoLivroAntigo, livroNovo);
        return true;
    }

    public List<Livro> getLivro()
    {
        return Collections.unmodifiableList( this.livros);
    }

    @Override
    public Iterator<Livro> iterator()
    {
        return livros.iterator();
    }


    public void removerTodosLivros()
    {
        this.livros.clear();
    }
}