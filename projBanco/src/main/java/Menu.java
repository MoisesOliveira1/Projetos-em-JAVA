import java.util.Scanner;

public class Menu {

    private static float valor;
    public static void main(String[] args){
        ContaCorrente conta = new ContaCorrente();
        Scanner leitura = new Scanner(System.in);
        String nome;
        int num, op;
        float saldo;
        do{
            System.out.println("----- Projeto Conta Cprrente-----");
            System.out.println("1- Inserir Conta:");
            System.out.println("2- Extrato");
            System.out.println("3- Depositar");
            System.out.println("4- Saque");
            System.out.println("5- Saldo");
            System.out.println("0 - Sair ---------------------------");
            leitura.nextLine();
            op = leitura.nextInt();
            switch(op){

                case 1 :
                    System.out.println("Entre com o Numero:");
                    num = leitura.nextInt();

                    System.out.println("Entre com o Titular: ");
                    nome = leitura.nextLine();

                    System.out.println("Entre com o Saldo");
                    saldo = leitura.nextFloat();


                    conta.inseredados(nome, num, saldo);
                    break;
                case 2 :
                    conta.extrato();

                    break;
                case 3 :
                    System.out.println("Entre com o valor a ser depositado: ");
                    valor = leitura.nextFloat();
                    conta.depositar(valor);
                    break;
                case 4:
                    conta.mostrarsaldo();
                    System.out.println("Entre com o valor a ser sacado: ");
                    valor = leitura.nextFloat();
                    conta.sacar(valor);
                    break;
                case 5:
                    conta.mostrarsaldo();
                    break;
            }
        }while(op != 0);
    }
}