import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("########## CALCULADORA MEDIA DE GOLS ##########");
        System.out.println("##### MEDIA DE GOLS #####");
        System.out.println();

        String nome;
        List<Integer> golsPorPartida;


        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe o nome do jogador: ");
            nome = entrada.nextLine();

            String continuar;
            System.out.print("Voce gostaria de adicionar gols a este jogador? (s/n): ");
            continuar = entrada.nextLine();

            int partida = 1;
            golsPorPartida = new ArrayList<>();

            while ("s".equalsIgnoreCase(continuar)) {
                System.out.printf("Quantos gols %s fez na partida %d: ", nome, partida);
                int golsNaPartida = entrada.nextInt();
                golsPorPartida.add(golsNaPartida);

                partida++;

                System.out.print("Deseja continuar (s/n): ");
                continuar = entrada.next();
            }
        }

        imprimirMediaDeGols(nome, golsPorPartida);
    }

    private static void imprimirMediaDeGols(String nome, List<Integer> golsPorPartida) {
        // Realizar o calculo da media e imprimir na tela
//        double totalGols = 0;
//
//        for (Integer golsNaPartida : golsPorPartida)
//            totalGols += golsNaPartida;
//
//        double media = 0;
//
//        if (!golsPorPartida.isEmpty())
//            media = totalGols / golsPorPartida.size();

        /*
        // stream() -> eh um fluxo que percorre os elementos de uma lista
        Stream<Integer> stream = golsPorPartida.stream();
        // convertendo os valores inteiros em reais
        DoubleStream doubleStream = stream.mapToDouble(Integer::doubleValue);
        // obtendo a media
        OptionalDouble optionalDouble = doubleStream.average();
        // retorna a media ou zero
        double media = optionalDouble.orElse(0.0); */

        double media = golsPorPartida.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

        System.out.printf("\nO %s fez uma media de %.2f gols por jogo\n", nome, media);
    }

}