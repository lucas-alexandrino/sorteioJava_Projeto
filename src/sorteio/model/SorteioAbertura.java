package sorteio.model;

import java.util.ArrayList;

public class SorteioAbertura extends Sorteio{
    @Override
    public Participante sortearDuplas(ArrayList<Participante> listaParticipantes) {
        int numeroAleatorio = (int) ( Math.random() * listaParticipantes.size());
        //retornando elemento da lista no indice sorteado
        return listaParticipantes.get(numeroAleatorio);
    }

    @Override
    public void sortearTema() {
        int numeroAleatorio = (int) (Math.random() * 8);
        switch (numeroAleatorio){
            case 0:
                System.out.println("\nO tema da abertura será: Mentalidade de Persistência!");
                break;
            case 1:
                System.out.println("\nO tema da abertura será: Mentalidade de Crescimento!");
                break;
            case 2:
                System.out.println("\nO tema da abertura será: Mentalidade de Responsabilidade Pessoal!");
                break;
            case 3:
            System.out.println("\nO tema da abertura será: Mentalidade de Orientação ao Futuro!");
            break;
            case 4:
                System.out.println("\nO tema da abertura será: Habilidade de Comunicação!");
                break;
            case 5:
                System.out.println("\nO tema da abertura será: Habilidade de Proatividade!");
                break;
            case 6:
                System.out.println("\nO tema da abertura será: Habilidade de Orientação ao Detalhe!");
                break;
            case 7:
                System.out.println("\nO tema da abertura será: Habilidade de Trabalho em Equipe!");
                break;
        }

    }

    @Override
    public void sortearFeedback(ArrayList<Participante> listaParticipantes) {}

}
