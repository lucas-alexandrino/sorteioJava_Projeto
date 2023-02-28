package sorteio.model;

import java.util.ArrayList;

public abstract class Sorteio {

   public abstract Participante sortearDuplas(ArrayList<Participante> listaParticipantes);
   public abstract void sortearTema();
   public abstract void sortearFeedback(ArrayList<Participante> listaParticipantes);
}
