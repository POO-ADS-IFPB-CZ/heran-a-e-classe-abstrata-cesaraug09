package model;

public class ContaEspecial extends Conta{
    private double limite;

    public ContaEspecial(String numero, String nome_titular, double limite) {
        super(numero, nome_titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
        System.out.println("Limite reajustado com sucesso! seu limite atual é de "+getLimite()+"!");
    }

    @Override
    public boolean sacar(double valorSaque){
        if(valorSaque > limite + this.saldo){
            System.out.println("Não foi possível realizar o saque! Verifique se você possui crédito e tente novamente.");
            return false;
        }
        this.saldo -= valorSaque;
        System.out.println("Saque realizado com sucesso!");
        return true;
    }

}
