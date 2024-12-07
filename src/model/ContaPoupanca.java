package model;

public class ContaPoupanca extends Conta{


    public ContaPoupanca(String numero, String nome_titular) {
        super(numero, nome_titular);
    }

    public void reajustar(double percentual){
        double saldo = this.getSaldo();
        double reajuste = saldo * percentual;
        this.depositar(reajuste);
    }

}
