package ProgramaJOptionPane;

import javax.swing.*;
import java.util.ArrayList;


public class Main {

    // Lista de contas bancárias para simulação
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args) {

        // Lista de contas bancárias para simulação
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {

        // Loop para realizar operações enquanto o usuário não desejar sair
        int operacao = Integer.parseInt(JOptionPane.showInputDialog(
                //

                "Selecione a operação desejada"+
                "\n+--------------------------------------+\n" +

                "----------- 1 Cadastrar conta:\n" +
                "----------- 2 Sacar:\n" +
                "----------- 3 Depositar:\n" +
                "----------- 4 Transferir\n" +
                "----------- 5 Extrato:\n" +
                "----------- 6 Sair:\n" +
                "+---------------------------------------+\n" +
                "==> "  ));


        // Switch de operações

        switch (operacao) {
            case 1:
                // Criar Conta
                cadastarConta();
                break;
            case 2:
                // Sacar
                sacar();
                break;
            case 3:
                // Depositar
                depositar();
                break;
            case 4:
                // Transferir
                transferir();
                break;
            case 5:
                // Extrato
                listar();
                break;
            case 6:
                // Sair

                // JOptionPane.showMessageDialog é usado para exibir uma caixa
                // de diálogo simples com uma mensagem. Ele faz parte da biblioteca Swing do Java
                JOptionPane.showMessageDialog(null, "Obrigado!!");
                System.exit(0);
            default:
                // caso a opção escolhida seja inválida, exibe uma mensagem e volta ao menu de operações
                JOptionPane.showMessageDialog(null,
                        "Operação inválida. Tente novamente.");
                operacoes();
                break;
        }


    }

    public static void cadastarConta(){
        Pessoa pessoa = new Pessoa();
        // solicitando dados da pessoa e criando a conta
        // JOptionPane.showInputDialog é usado para exibir
        // uma caixa de diálogo que solicita ao usuário uma entrada de texto
        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        pessoa.setCpf(JOptionPane.showInputDialog("CPF"));
        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));
        pessoa.setTelefone(JOptionPane.showInputDialog("Telefone: "));

        // instanciando a classe conta e adicionando a pessoa na conta
        Conta conta = new Conta(pessoa);
        // adicionando a conta na lista de contas bancárias
        contasBancarias.add(conta);
        // exibe uma mensagem de sucesso ao cadastrar a conta

        JOptionPane.showMessageDialog(null,
                "Conta criada com sucesso!");
        // chamando o menu operações
        operacoes();

    }

    private static Conta localizarConta(int numeroConta){
        Conta conta = null;
        // verificando se a lista não está vazia e se a conta existe na lista
        if(!contasBancarias.isEmpty()){
            // percorrendo o Array das contas bancárias
            for(Conta c : contasBancarias){
                // se a conta localizada tem o número da conta igual ao digitado pelo usuário
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                    break;
                }
            }
        }
        return conta;

    }
    public static void sacar(){
        // solicitando número da conta
        // Para converter a entrada de um JOptionPane.showInputDialog em um número inteiro, você pode usar o método
        // Integer.parseInt
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digíte o numero da conta: "));

        // localizando o número utilizando o método localizarConta
        Conta conta = localizarConta(numeroConta);
        // se conta for diferente de null e o seu saldo for menor ou igual a zero, prossiga
        if(conta!= null) {
            // Para converter a entrada de um JOptionPane.showInputDialog em um número inteiro, você pode usar o método
            // Double.parseDouble
            Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog(
                    "Qual valor deseja sacar:"));
            // utilizando o método sacar para o valor informao para saque
            conta.sacar(valorSaque);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Conta não encontrada ou saldo insuficiente.");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void depositar(){
        int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o número da conta: "));

        // localizando conta origem
        Conta contaDestino = localizarConta(numeroContaDestino);
        // se a conta origem for diferente de null, prossiga
        if(contaDestino!= null){
            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog(
                    "Informe o valor a ser depositado: "));

            // utilizando o método depositar para o valor informado para deposito
            contaDestino.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null,
                    "Valor depositado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Conta não encontrada.");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void transferir(){
        JOptionPane.showMessageDialog(null,
                "Realizando transferência... ");
        int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe a conta destino: "));

        // localizando conta destino
        Conta contaDestino = localizarConta(numeroContaDestino);
        // se a conta destino for diferente de null e o seu saldo for maior ou igual a zero, prossiga
        if(contaDestino!= null) {
            int numeroContaOrigem = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe a conta origem: "));
            // localizando conta origem
            Conta contaOrigem = localizarConta(numeroContaOrigem);
            //
            if(contaOrigem!= null){
                double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog(
                        "Qual valor deseja transfeir: "));

                // utilizando o método transferir para transferir o valor informado para a conta destino
                contaOrigem.transferir(contaDestino, valorTransferencia);

                JOptionPane.showMessageDialog(null,
                        "Transferência realizada com sucesso!");
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Transferência não pode ser relizada! Ambas ou algumas das contas inexistem!");
        }
        // chamando o menu operações
        operacoes();

    }
    public static void listar(){
        System.out.println("Extrato: ");
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o número da conta a ser localizada: "));

        // localizando o número da conta
        Conta conta = localizarConta(numeroConta);
        // se a conta for diferente de null, prossiga
        if(conta != null){
            // se o Array das contas bancárias não estiver vazio, a lista de contas será impressa.
            if(!contasBancarias.isEmpty()) {
                for(Conta c : contasBancarias){
                    System.out.println(c);
                }
            }
        } else{
            JOptionPane.showMessageDialog(null,
                    "Conta inexistente!");
        }
        // chamando o menu operções
        operacoes();


    }


}
