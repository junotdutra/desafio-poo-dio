import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Curso curso3 = new Curso();
        curso3.setTitulo("curso Rails");
        curso3.setDescricao("descrição curso Rails");
        curso3.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:");
        devCamila.getConteudos().forEach(conteudoDev -> System.out.println(conteudoDev.getConteudo().getTitulo()));
        devCamila.progredir(curso1);
        devCamila.progredir(curso2);
        devCamila.progredir(curso3);
        System.out.println("-");
        System.out.println("Conteúdos Concluidos João: ");
        devCamila.getConteudos().stream().filter(conteudoDev -> conteudoDev.isConcluido()).forEach(conteudoDev -> System.out.println(conteudoDev.getConteudo().getTitulo() + " - Conclusão: " +
                conteudoDev.getDataConclusao()));
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:");
        devJoao.getConteudos().forEach(conteudoDev -> System.out.println(conteudoDev.getConteudo().getTitulo()));
        devJoao.progredir(curso1);
        devJoao.progredir(curso2);
        devJoao.progredir(mentoria);
        System.out.println("-");
        System.out.println("Conteúdos Concluidos João: ");
      devJoao.getConteudos().stream().filter(conteudoDev -> conteudoDev.isConcluido()).forEach(conteudoDev -> System.out.println(conteudoDev.getConteudo().getTitulo() + " - Conclusão: " +
              conteudoDev.getDataConclusao()));
        System.out.println("XP:" + devJoao.calcularTotalXp());
    }
}
