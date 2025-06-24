import Exceptions.SaldoInsuficienteException;

public class ContaCorrente {
    private final int agencia;
    private final int numero;
    private double saldo;

    public ContaCorrente(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
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

    public void transferir(int numero, double valor) {
        if(this.saldo - valor >= 0){
            // TODO: criar alguma forma de retirar o saldo da conta atual e enviar para a conta passada nos parametros
        }else{
            throw new SaldoInsuficienteException("Você não possui saldo o suficiente para realizar a transferência.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
