import Exceptions.FaturaExcedeLimiteException;
import Exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

    private double fatura;
    private double limite = 1000;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.fatura = 0;
    }

    public void cartaoDeCredito(double valor) {
        if(this.fatura + valor < this.limite) {
            this.fatura += valor;
        }else{
            throw new FaturaExcedeLimiteException("Você não pode gastar esse valor, pois excede o limite da sua fatura.");
        }
    }

    public void cartaoDeDebito(double valor) {
        if(super.saldo - valor > 0) {
            super.saldo -= valor;
        }else{
            throw new SaldoInsuficienteException("Você não pode gastar esse valor, pois não tem saldo o suficiente.");
        }
    }

    public double getFatura() {
        return fatura;
    }

    public double getLimite() {
        return limite;
    }
}
