
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CatálogoLivrosTest {
    static final Livro LIVRO_CHILDREN =
            new Livro( "Infantil destinado para as crianças", TIPO_LIVRO.C );
    static final Livro LIVRO_YOUNG =
            new Livro( "jovem destinado ao publico jovem", TIPO_LIVRO.Y );
    static final Livro LIVRO_ADULT =
            new Livro( "Adulto destinado ao publico adulto", TIPO_LIVRO.A );

    private CatálogoLivros catálogoLivros;

    @BeforeEach
    public void setUp()
    {
        this.catálogoLivros = new CatálogoLivros();
    }

    @AfterEach
    public void tearDown()
    {
        this.catálogoLivros.removerTodosLivros();
    }

    @Test
    public void testDeveAdicionarLivro()
    {
        catálogoLivros.adicionarLivro(LIVRO_CHILDREN);
        catálogoLivros.adicionarLivro(LIVRO_YOUNG);

        assertThat(catálogoLivros, containsInAnyOrder(LIVRO_YOUNG, LIVRO_CHILDREN) );
    }

    @Test
    public void testDeveRemoverLivro()
    {
        catálogoLivros.adicionarLivro(LIVRO_CHILDREN);
        catálogoLivros.adicionarLivro(LIVRO_YOUNG);
        catálogoLivros.adicionarLivro(LIVRO_ADULT);

        catálogoLivros.removerLivro(LIVRO_ADULT);
        assertThat(catálogoLivros, not( contains(LIVRO_ADULT) ) );
    }

    @Test
    public void testDeveSubstituirLivro()
    {
        catálogoLivros.adicionarLivro(LIVRO_CHILDREN);
        catálogoLivros.adicionarLivro(LIVRO_YOUNG);

        catálogoLivros.substituir(LIVRO_CHILDREN, LIVRO_ADULT);
        assertThat(catálogoLivros, contains(LIVRO_ADULT, LIVRO_YOUNG) );
    }
    @Test
    public void testNãoDeveSubstituirLivro()
    {
        catálogoLivros.adicionarLivro(LIVRO_CHILDREN);

        catálogoLivros.substituir(LIVRO_ADULT, LIVRO_YOUNG);
        catálogoLivros.substituir(LIVRO_ADULT, LIVRO_CHILDREN);

        assertThat(catálogoLivros, not( contains(LIVRO_ADULT) ) );
        assertThat(catálogoLivros, not( contains(LIVRO_YOUNG) ) );

        assertThat(catálogoLivros, contains(LIVRO_CHILDREN) );
    }

    @Test
    public void testDeveRemoverTodosLivros()
    {
        catálogoLivros.adicionarLivro(LIVRO_CHILDREN);
        catálogoLivros.adicionarLivro(LIVRO_YOUNG);

        catálogoLivros.removerTodosLivros();

        assertThat( catálogoLivros.getLivro(), empty() );
    }
}
