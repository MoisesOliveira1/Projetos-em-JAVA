
import java.util.Objects;
import java.util.StringJoiner;

enum
TIPO_LIVRO { C, Y, A }

public class Livro {
    private String descrição;


    public Livro()
    {
        this( "--- sem descrição ---" , TIPO_LIVRO.C );
    }

    public Livro(String descrição, TIPO_LIVRO tamanho )
    {
        setDescrição( descrição );
    }

    public String getDescrição()
    {
        return descrição;
    }

    public void setDescrição( String descrição )
    {
        this.descrição = Objects.requireNonNullElse( descrição, "--- sem descrição ---" );
    }



    @Override
    public String toString()
    {
        return new StringJoiner( ", ", Livro.class.getSimpleName() + "{", "}" )
                .add( "descrição='" + descrição + "'" )
                .toString();
    }
}