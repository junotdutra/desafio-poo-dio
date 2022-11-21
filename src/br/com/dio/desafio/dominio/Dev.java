package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {
    private String nome;
    private Set<ConteudoDev> conteudos = new LinkedHashSet<>();


    public void inscreverBootcamp(Bootcamp bootcamp){

        for (Conteudo conteudo: bootcamp.getConteudos()){
            this.conteudos.add(new ConteudoDev(conteudo));
        }
    }

    public void progredir(Conteudo conteudo) {
 this.conteudos.stream().filter(conteudoDev -> conteudoDev.getConteudo().equals(conteudo))
         .findAny().ifPresentOrElse(
         conteudoDev -> {
             conteudoDev.setDataConclusao(LocalDate.now());
             conteudoDev.setConcluido(true);
         },() -> {
             System.out.println("Conteudo não cadastrado para o Dev: " + conteudo.getTitulo());
                 }
 );
    }

    public double calcularTotalXp() {
        Iterator<ConteudoDev> iterator = this.conteudos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            ConteudoDev cd = iterator.next();
            if(cd.isConcluido()) {
                double next = cd.getConteudo().calcularXp();
                soma += next;
            }
        }
        return soma;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ConteudoDev> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<ConteudoDev> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudos, dev.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudos);
    }
}