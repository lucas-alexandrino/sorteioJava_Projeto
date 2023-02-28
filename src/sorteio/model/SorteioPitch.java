package sorteio.model;

import java.util.ArrayList;

public class SorteioPitch extends Sorteio{
    @Override
    public Participante sortearDuplas(ArrayList<Participante> listaParticipantes) {
        int numeroAleatorio = (int) ( Math.random() * listaParticipantes.size());
        //retornando elemento da lista no indice sorteado
        return listaParticipantes.get(numeroAleatorio);
    }
    public void sortearFeedback(ArrayList<Participante> listaParticipantes){
            int numeroAleatorio = (int) ( Math.random() * listaParticipantes.size());
            Participante participante = listaParticipantes.get(numeroAleatorio);
            System.out.println(participante.getNome());

            int numeroAleatorio2 = (int) ( Math.random() * listaParticipantes.size());
            while (numeroAleatorio2 == numeroAleatorio){
                numeroAleatorio2 = (int) ( Math.random() * listaParticipantes.size());
            }

            participante = listaParticipantes.get(numeroAleatorio2);
            System.out.println(participante.getNome());

    }
    @Override
    public void sortearTema(){}

}
