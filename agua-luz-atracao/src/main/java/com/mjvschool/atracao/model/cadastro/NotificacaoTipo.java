package com.mjvschool.atracao.model.cadastro;

public enum NotificacaoTipo {
    SMS("S", "SMS"),
    WHATS("w", "WHATS");

    String siglaNotificacao;
    String nome;
    
    private NotificacaoTipo(String siglaNotificacao, String nome){
        this.siglaNotificacao = siglaNotificacao;
        this.nome = nome;
    }

    public String getSiglaNotificacao(){
        return siglaNotificacao;

    }

    public String getNome(){
        return nome;
    }
    
    
}
