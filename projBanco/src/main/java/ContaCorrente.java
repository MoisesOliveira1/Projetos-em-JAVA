class ContaCorrente {
    private int número;
    private String titular;
    private double saldo;
    private double CPMF;
    public ContaCorrente() {
        setNúmero(0);
        setTitular("---sem nome---");
    }

    public ContaCorrente(int número, String titular, double saldoInicial) {
        setNúmero(número);
        setTitular(titular);
        depositar(saldoInicial);
    }

    public void sacar(double umaQuantia) {
        if (umaQuantia > 0 && umaQuantia <= this.saldo){
            CPMF= umaQuantia + (umaQuantia/0.01);
        }
            this.saldo -= CPMF;
    }

    public void depositar(double umaQuantia) {
        if (umaQuantia > 0)
            this.saldo += umaQuantia;
    }

    public void setNúmero(int umNúmero) {
        if (umNúmero > 0)
            número = umNúmero;
    }

    public int getNúmero() {
        return número;
    }

    public void setTitular(String umTitular) {
        if (umTitular != null && umTitular.length() > 0)
            this.titular = umTitular;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    void inseredados(String a, int b, float c) {
        this.titular = a;
        this.número = b;
        this.saldo = c;
    }

    @Override
    public String toString() {
        return "Conta: " + this.getNúmero() +
                "; Titular: " + this.getTitular() +
                "; R$ " + this.getSaldo();
    }

    void extrato() {
        System.out.println("Dono da Conta: " + this.getNúmero());
        System.out.println("Numero da Conta: " + this.getTitular());
        System.out.println("Saldo atual: " + this.getSaldo());
    }
    void mostrarsaldo(){
        System.out.println("Saldo Atual: " + this.getSaldo());

    }
}