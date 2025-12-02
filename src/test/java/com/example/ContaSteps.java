package com.example;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Implementação dos passos BDD para abertura de conta corrente.
 */
public class ContaSteps {

    private static final double DELTA = 0.0001;
    private static final double SALDO_CONTA_EXISTENTE = 500.0;
    private static final double SALDO_NOVA_CONTA = 200.0;

    private ContaService contaService;
    private Conta contaCriada;
    private Conta contaCriada2;
    private String nome;
    private String cpf;
    private Double saldoInicial;
    private String mensagemErro;

    /**
     * Passo para informar nome, CPF e saldo inicial.
     *
     * @param nomeInformado nome informado
     * @param cpfInformado  CPF informado
     * @param saldo         saldo inicial
     */
    @Dado("que o usuário informou nome {string}, CPF {string} e saldo inicial de {double} reais")
    public void usuarioInformouNomeCpfSaldo(String nomeInformado,
                                            String cpfInformado,
                                            Double saldo) {
        contaService = new ContaService();
        nome = nomeInformado;
        cpf = cpfInformado;
        saldoInicial = saldo;
    }

    /**
     * Passo para confirmar criação da conta.
     */
    @Quando("confirma a criação da conta")
    public void confirmaCriacaoConta() {
        contaCriada = contaService.abrirConta(nome, cpf, "senhaSegura", saldoInicial);
        mensagemErro = contaService.getMensagemErro();
    }

    /**
     * Verifica se um número de conta foi gerado.
     */
    @Entao("o sistema deve gerar um número de conta único")
    public void sistemaDeveGerarNumeroUnico() {
        assertNotNull(contaCriada, "Conta não foi criada");
        assertNotNull(contaCriada.getNumero(), "Número da conta não foi gerado");
    }

    /**
     * Verifica se a conta foi criada com o saldo esperado.
     *
     * @param saldoEsperado saldo esperado
     */
    @Entao("o sistema deve armazenar a conta com saldo inicial de {double} reais")
    public void sistemaDeveArmazenarContaSaldo(Double saldoEsperado) {
        assertNotNull(contaCriada, "Conta não foi criada");
        assertEquals(saldoEsperado.doubleValue(), contaCriada.getSaldo(), DELTA);
        Conta contaBuscada = contaService.buscarPorCpf(contaCriada.getCpf());
        assertNotNull(contaBuscada, "Conta não foi encontrada pelo CPF");
        assertEquals(contaCriada.getNumero(), contaBuscada.getNumero());
    }

    /**
     * Passo para informar nome e CPF sem saldo inicial.
     *
     * @param nomeInformado nome informado
     * @param cpfInformado  CPF informado
     */
    @Dado("que o usuário informou nome {string}, CPF {string} e não informou saldo inicial")
    public void usuarioInformouNomeCpfSemSaldo(String nomeInformado,
                                               String cpfInformado) {
        contaService = new ContaService();
        nome = nomeInformado;
        cpf = cpfInformado;
        saldoInicial = null;
    }

    /**
     * Verifica se a conta foi criada com saldo zero.
     */
    @Entao("o sistema deve criar a conta com saldo inicial de 0 reais")
    public void sistemaDeveCriarContaSaldoZero() {
        assertNotNull(contaCriada, "Conta não foi criada");
        assertEquals(0.0, contaCriada.getSaldo(), DELTA);
    }

    /**
     * Garante que já existe uma conta com o CPF informado.
     *
     * @param cpfExistente CPF já cadastrado
     */
    @Dado("que já existe uma conta para o CPF {string}")
    public void jaExisteContaParaCpf(String cpfExistente) {
        contaService = new ContaService();
        Conta contaExistente = contaService.abrirConta(
                "Cliente Antigo", cpfExistente, "senha123", SALDO_CONTA_EXISTENTE);
        assertNotNull(contaExistente, "Conta inicial não foi criada corretamente");
    }

    /**
     * Passo em que o usuário tenta criar nova conta com o mesmo CPF.
     */
    @Quando("o usuário tenta criar uma nova conta com o mesmo CPF")
    public void usuarioTentaCriarContaComMesmoCpf() {
        contaCriada2 = contaService.abrirConta(
                "Novo Cliente", "12345678900", "senha456", SALDO_NOVA_CONTA);
        mensagemErro = contaService.getMensagemErro();
    }

    /**
     * Verifica que a operação foi recusada.
     */
    @Entao("o sistema deve recusar a operação")
    public void sistemaDeveRecusarOperacao() {
        assertNull(contaCriada2, "Conta não deveria ter sido criada");
    }

    /**
     * Verifica a mensagem exibida pelo sistema.
     *
     * @param mensagemEsperada mensagem esperada
     */
    @Entao("o sistema deve exibir a mensagem {string}")
    public void sistemaDeveExibirMensagem(String mensagemEsperada) {
        assertEquals(mensagemEsperada, mensagemErro);
    }

    /**
     * Passo em que o usuário informa um nome vazio.
     *
     * @param cpfInformado CPF informado
     */
    @Dado("que o usuário informou um nome vazio e CPF {string}")
    public void usuarioInformouNomeVazio(String cpfInformado) {
        contaService = new ContaService();
        nome = "";
        cpf = cpfInformado;
        saldoInicial = 0.0;
    }

    /**
     * Passo em que o usuário tenta criar a conta com nome inválido.
     */
    @Quando("tenta criar a conta")
    public void tentaCriarContaNomeVazio() {
        contaCriada = contaService.abrirConta(nome, cpf, "senhaSegura", saldoInicial);
        mensagemErro = contaService.getMensagemErro();
    }
}
