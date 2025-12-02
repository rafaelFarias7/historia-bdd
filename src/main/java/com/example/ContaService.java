package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Serviço responsável por regras de negócio da abertura e consulta de contas.
 */
public class ContaService {

    private Map<String, Conta> contasPorCpf = new HashMap<>();
    private String mensagemErro;

    /**
     * Abre uma nova conta, validando nome e CPF e aplicando saldo inicial.
     *
     * @param nomeInformado   nome informado pelo usuário
     * @param cpfInformado    CPF informado pelo usuário
     * @param senha           senha de acesso
     * @param saldoInicial    saldo inicial (pode ser null para 0)
     * @return conta criada ou null em caso de erro
     */
    public Conta abrirConta(String nomeInformado, String cpfInformado,
                            String senha, Double saldoInicial) {
        mensagemErro = null;

        if (nomeInformado == null || nomeInformado.trim().isEmpty()) {
            mensagemErro = "Nome inválido";
            return null;
        }

        if (contasPorCpf.containsKey(cpfInformado)) {
            mensagemErro = "CPF já vinculado a uma conta";
            return null;
        }

        double saldo = saldoInicial != null ? saldoInicial.doubleValue() : 0.0;
        String numeroConta = gerarNumeroConta();

        Conta conta = new Conta(numeroConta, nomeInformado, cpfInformado, senha, saldo);
        contasPorCpf.put(cpfInformado, conta);

        return conta;
    }

    /**
     * Gera um número de conta pseudo-único.
     *
     * @return número da conta.
     */
    private String gerarNumeroConta() {
        return UUID.randomUUID().toString();
    }

    /**
     * Busca uma conta pelo CPF.
     *
     * @param cpf CPF da conta.
     * @return conta encontrada ou null se não existir.
     */
    public Conta buscarPorCpf(String cpf) {
        return contasPorCpf.get(cpf);
    }

    /**
     * @return mensagem de erro da última operação de abertura de conta.
     */
    public String getMensagemErro() {
        return mensagemErro;
    }
}
