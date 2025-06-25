public class Main {
    public static void main(String[] args) {
        Cliente joao = new Cliente("Joao Vitor", "123.123.123-12");
        ContaCorrente contaCorrente = new ContaCorrente(joao);

        System.out.println(contaCorrente.obterInfoDono());
        System.out.println("Limite do cartão de crédito: "+contaCorrente.getLimite());
        System.out.println("Fatura atual: "+contaCorrente.getFatura());
        System.out.println("Saldo atual: "+contaCorrente.getSaldo());

        System.out.println("========================================");
        contaCorrente.depositar(1500);
        contaCorrente.cartaoDeCredito(249.99);
        System.out.println(contaCorrente.obterInfoDono());
        System.out.println("Fatura atual: "+contaCorrente.getFatura());
        System.out.println("Saldo atual: "+contaCorrente.getSaldo());

        // contaCorrente.sacar(2000); Exception enviada com sucesso

        System.out.println("========================================");
        contaCorrente.pagarFatura(249.99);
        System.out.println(contaCorrente.obterInfoDono());
        System.out.println("Fatura atual: "+contaCorrente.getFatura());
        System.out.println("Saldo atual: "+contaCorrente.getSaldo());

        System.out.println("========================================");
        Cliente aldre = new Cliente("Aldre Fernanda", "321.321.321-32");
        ContaPoupanca contaPoupanca = new ContaPoupanca(aldre);
        contaCorrente.transferir(contaPoupanca, 250);
        System.out.println(contaCorrente.obterInfoDono());
        System.out.println("Fatura atual: "+contaCorrente.getFatura());
        System.out.println("Saldo atual: "+contaCorrente.getSaldo());

        System.out.println("========================================");
        System.out.println(contaPoupanca.obterInfoDono());
        System.out.println("Saldo atual: "+contaPoupanca.getSaldo());

        System.out.println("========================================");
        contaPoupanca.renderDinheiro();
        System.out.println(contaPoupanca.obterInfoDono());
        System.out.println("Saldo atual: "+contaPoupanca.getSaldo());
    }
}