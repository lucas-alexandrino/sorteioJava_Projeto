package sorteio.model;

import java.util.ArrayList;

public class SorteioPitch extends Sorteio{
    @Override
    public Participante sortearDuplas(ArrayList<Participante> listaParticipantes) {
        int numeroAleatorio = (int) ( Math.random() * listaParticipantes.size());
        //retornando elemento da lista no indice sorteado
        return listaParticipantes.get(numeroAleatorio);
    }

    @Override
    public void sortearTema(){}

}
