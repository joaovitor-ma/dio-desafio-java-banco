import Exceptions.SaldoInsuficienteException;

public abstract class Conta {
    protected static int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente donoDaConta;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0;
        this.donoDaConta = cliente;
    }

    public String obterInfoDono() {
        return "Nome: "+donoDaConta.getNome()+", CPF: "+donoDaConta.getCpf();
    }

    public void sacar(double valor) {
        if(this.saldo - valor >= 0) {
            this.saldo -= valor;
        }else{
            throw new SaldoInsuficienteException("Você não possui saldo o suficiente para realizar o saque.");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(Conta contaDestino, double valor) {
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
            contaDestino.depositar(valor);
        }else{
            throw new SaldoInsuficienteException("Você não possui saldo o suficiente para realizar a transferência.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
