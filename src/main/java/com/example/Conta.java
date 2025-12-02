package com.example;

/**
 * Representa uma conta bancária simples com número, nome do titular,
 * CPF, senha e saldo.
 */
public class Conta {
    private String numero;
    private String nome;
    private String cpf;
    private String senha;
    private double saldo;

    /**
     * Cria uma nova conta.
     *
     * @param numero número único da conta
     * @param nome   nome do titular
     * @param cpf    CPF do titular
     * @param senha  senha de acesso
     * @param saldo  saldo inicial
     */
    public Conta(String numero, String nome, String cpf, String senha, double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = saldo;
    }

    /**
     * @return número da conta.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return nome do titular da conta.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return CPF do titular da conta.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return senha cadastrada na conta.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return saldo atual da conta.
     */
    public double getSaldo() {
        return saldo;
    }
}


