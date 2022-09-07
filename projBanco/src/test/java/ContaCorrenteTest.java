import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ContaCorrenteTest {
    @Test
    public void testSacar(){
        ContaCorrente conta = new ContaCorrente( 555, "ana", 1000.99 );

        conta.sacar( 100 );
        assertEquals( 900.99, conta.getSaldo(), 0.0  );

        conta.sacar( -100 ); // sacar quantias negativas
        assertEquals( 900.99, conta.getSaldo(), 0.0  );

        conta.sacar( 10000 ); // sacar quando não há fundos
        assertEquals( 900.99, conta.getSaldo(), 0.0  );

        conta.sacar( 900.99 ); // "zerar" a conta
        assertEquals( 0.0, conta.getSaldo(), 0.0  );
    }

    @Test
    public void testSetTitular()
    {
        ContaCorrente conta = new ContaCorrente();


        conta.setTitular( "ana" );
        assertEquals( "ana" , conta.getTitular() );


        conta.setTitular( null ); // caso argumento seja null
        assertEquals( "ana" , conta.getTitular() );

        conta.setTitular( "" ); // caso argumento seja "String vazia"
        assertEquals( "ana" , conta.getTitular() );
    }

    @Test
    public void testDepositar()
    {
        ContaCorrente conta = new ContaCorrente();

        conta.depositar( 1000 );
        assertEquals( 1000.00, conta.getSaldo(), 0.0  );

        conta.depositar( -10 );
        assertEquals( 1000.00, conta.getSaldo(), 0.0  );
    }

    @Test
    public void testSetNúmero()
    {
        ContaCorrente conta = new ContaCorrente();

        conta.setNúmero( 555 );
        assertEquals( 555, conta.getNúmero() );

        conta.setNúmero( -555 );
        assertEquals( 555, conta.getNúmero() );
    }

    @Test
    public void testConstrutores()
    {
        // construtor default
        ContaCorrente c1 = new ContaCorrente();
        assertEquals( 0, c1.getNúmero() );
        assertEquals( "---sem nome---", c1.getTitular());
        assertEquals( 0.0, c1.getSaldo(), 0.0 );

        // construtor com argumentos
        ContaCorrente c2 = new ContaCorrente( 888, "pedro", 2380.99);
        assertEquals( 888, c2.getNúmero() );
        assertEquals( "pedro", c2.getTitular());
        assertEquals( 2380.99, c2.getSaldo(), 0.0 );
    }

    @Test
    public void testToString(){
        String str1 = "Conta: 0; Titular: ---sem nome---; R$ 0.0";
        String str2 = "Conta: 777; Titular: pedro; R$ 2300.99";

        ContaCorrente c1 = new ContaCorrente();
        ContaCorrente c2 = new ContaCorrente(777, "pedro", 2300.99 );

        assertEquals( str1, c1.toString() );
        assertEquals( str2, c2.toString() );
    }
}