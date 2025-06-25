public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void renderDinheiro() {
        super.saldo += (super.saldo*0.005);
    }

}
