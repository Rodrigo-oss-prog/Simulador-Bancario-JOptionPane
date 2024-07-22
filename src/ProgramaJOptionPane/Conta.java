package ProgramaJOptionPane;

import ProgramaJOptionPane.utilitarios.Utils;

import javax.swing.*;

public class Conta {
    private static int contadorDaconta = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.setNumeroConta(contadorDaconta++);
        this.setPessoa(pessoa);

    }


    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // toString retorna uma String de represantação do objeto
    @Override
    public String toString() {
        return "Conta{" +
                "numero da Conta=" + this.numeroConta +
                "\nNome=" + this.pessoa.getNome()+
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nTelefone: " + this.pessoa.getTelefone() +
                "\nsaldo=" + Utils.doubleToString(this.getSaldo()) +
                '}';

    }

    public void depositar(Double valor){

        // se o valor for maior que zero
        if(valor > 0){
            // adiciona o valor ao saldo
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,
                    "Deposito realizado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Valor inválido para deposito!");
        }
    }

    public void sacar(Double valor){
        // se o valor for maior que zero e valor menor igual ao saldo
        if(valor > 0 && this.getSaldo() >= valor){
            // subtrai o valor do saldo
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null,
                    "Saque realizado com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null,
                    "Saldo insuficiente!");
        }

    }

    public void transferir(Conta destino, Double valor){
        // se o valor for maior que zero e valor menor igual ao saldo
        if(valor > 0 && valor <= getSaldo()){
            // subtrai o valor do saldo utilizando o método sacar
            sacar(valor);
            // adiciona o valor ao saldo do destino utilizando o método depositar
            destino.depositar(valor);
            JOptionPane.showMessageDialog(null,
                    "Transferência realizada com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null,
                    "Valor inválido para transferência!");
        }
    }

}
