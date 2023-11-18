package com.mygdx.quiz;

import java.util.List;

public class Quiz {
    private String pergunta;
    private List<String> alternativas;
    private int alternativaCorreta; // variável para guardar o índice da alternativa correta

    public Quiz(String pergunta, List<String> alternativas, int alternativaCorreta) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;

        if (alternativaCorreta < 0 || alternativaCorreta >= alternativas.size()) {
            throw new IllegalArgumentException("Índice de alternativa correta está fora dos limites permitidos");
        }
    }

    public String getPergunta() {
        return pergunta;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    // verificar se a alternativa escolhida é a correta
    public boolean alternativaECorreta(int alternativaEscolhida) {
        return alternativaEscolhida == alternativaCorreta;
    }
}