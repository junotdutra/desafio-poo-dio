package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class ConteudoDev {

    public ConteudoDev(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    private Conteudo conteudo;
    private boolean concluido = false;
    private LocalDate dataConclusao;

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConteudoDev that = (ConteudoDev) o;
        return Objects.equals(conteudo, that.conteudo) && Objects.equals(concluido, that.concluido) && Objects.equals(dataConclusao, that.dataConclusao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conteudo, concluido, dataConclusao);
    }
}
