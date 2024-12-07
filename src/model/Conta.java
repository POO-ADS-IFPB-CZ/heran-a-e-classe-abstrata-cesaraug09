package model;

public class Conta {
    private String numero;
    private String nome_titular;
    protected double saldo;

    public Conta(String numero, String nome_titular) {
        this.numero = numero;
        this.nome_titular = nome_titular;
        this.saldo = 0;
    }

    public String getNome_titular() {
        return nome_titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valorSaque){
        if (valorSaque >= this.getSaldo()){
            System.out.println("Não foi possível realizar o saque! Verifique se você possui crédito e tente novamente.");
            return false;
        }
        this.saldo -= valorSaque;
        System.out.println("Saque de "+valorSaque+" realizado com sucesso! Seu saldo atual: " + getSaldo());
        return true;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Deposito realizado com sucesso! Seu saldo atual: " + getSaldo());
    }
}
