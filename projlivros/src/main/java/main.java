public class main {
    public static void main(String[] args)
    {
        CatálogoLivros catálogoLivros = new CatálogoLivros();
        System.out.println("catalogo.tamanho()= " + catálogoLivros.tamanho());

        Livro c1= new Livro("50 tons",TIPO_LIVRO.A);
        Livro c2= new Livro("Percy Jackson",TIPO_LIVRO.Y);
        Livro c3= new Livro("Pequeno Principe",TIPO_LIVRO.C);
    }
}
