package view;
import model.Conta;
import model.ContaEspecial;
import model.ContaPoupanca;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Conta conta;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---SISTEMA BANCÁRIO---\nDigite 1 para criar uma conta:\nDigite 0 para SAIR.");
            opcao = scan.nextInt();

            switch(opcao) {
                case 1:
                    novaConta();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 0);
    }

    public static void novaConta() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Você deseja criar uma conta:\n1. Poupança.\n2. Especial.\n0. Voltar.");
            opcao = scan.nextInt();
            switch(opcao) {
                case 1:
                    criarConta(1);
                    break;
                case 2:
                    criarConta(2);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 0);
    }

    public static void criarConta(int tipoConta) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o numero da conta:");
        String numero = scan.nextLine();

        System.out.println("Informe o nome do titular:");
        String nomeTitular = scan.nextLine();

        if(tipoConta == 2) {
            System.out.println("Informe o limite da conta:");
            double limite = scan.nextDouble();
            conta = new ContaEspecial(numero, nomeTitular, limite);
            System.out.println("Conta Especial criada com sucesso!");
        } else {
            conta = new ContaPoupanca(numero, nomeTitular);
            System.out.println("Conta Poupança criada com sucesso!");
        }
        gerenciar(conta);
    }

    public static void gerenciar(Conta conta){
        Scanner scan = new Scanner(System.in).useLocale(new Locale("pt", "BR"));
        int opcao;
        System.out.println("Bem vindo, "+ conta.getNome_titular()+"! O que você deseja?");
        do{
            System.out.println("1. Depositar\n2. Sacar");

            if(conta instanceof ContaPoupanca){
                System.out.println("3. Reajuste");
            }
            if(conta instanceof ContaEspecial){
                System.out.println("3. Definir limite");
            }
            System.out.println("4. Informações\n0. Voltar.");

            opcao = scan.nextInt();
            switch(opcao) {
                case 1:
                    System.out.println("Quanto deseja depositar?");
                    conta.depositar(scan.nextDouble());
                    break;
                case 2:
                    System.out.println("Valor que deseja sacar?");
                    conta.sacar(scan.nextDouble());
                    break;
                case 3:
                    if(conta instanceof ContaPoupanca){
                        System.out.println("Quanto de reajuste aplicar? (Use valor de 0 à 1 separado por vírgula).");
                        ((ContaPoupanca) conta).reajustar(scan.nextDouble());
                    }
                    if(conta instanceof ContaEspecial){
                        System.out.println("Defina o seu novo crédito.");
                        ((ContaEspecial) conta).setLimite(scan.nextDouble());
                    }
                    break;
                case 4:
                    System.out.println("--------------------------------");
                    System.out.println("Titular:\n" +conta.getNumero()+" - "+conta.getNome_titular()+"\nSaldo atual: "+conta.getSaldo());
                    if(conta instanceof ContaEspecial){
                        System.out.println("Limite disponível: "+((ContaEspecial) conta).getLimite());
                    }
                    System.out.println("--------------------------------\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(opcao!=0);
    }

    public static void sair() {
        System.out.println("saindo...");
    }
}
