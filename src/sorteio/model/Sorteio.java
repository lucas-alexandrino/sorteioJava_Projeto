package sorteio.model;

import java.util.ArrayList;

public class Sorteio {
   public Participante sortear(ArrayList<Participante> listaParticipantes){
      int numeroAleatorio = (int) ( Math.random() * listaParticipantes.size());
      //retornando elemento da lista no indice sorteado
      return listaParticipantes.get(numeroAleatorio);
   }
}
