import Exceptions.FaturaExcedeLimiteException;
import Exceptions.SaldoInsuficienteException;
import Exceptions.ValorExcedeFaturaException;

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

    public void pagarFatura(double valor) {
        if(super.saldo - valor < 0) { // Caso o saldo do usuário seja menor que o valor inserido para pagar:
            throw new SaldoInsuficienteException("Você não tem saldo o suficiente para pagar este valor.");
        }
        if(this.fatura - valor < 0) { // Caso o usuário tente pagar um valor maior do que o que ele precisa:
            throw new ValorExcedeFaturaException("O valor inserido para pagar é maior do que o necessário");
        }

        this.fatura -= valor;
        super.saldo -= valor;
    }

    public double getFatura() {
        return fatura;
    }

    public double getLimite() {
        return limite;
    }
}
