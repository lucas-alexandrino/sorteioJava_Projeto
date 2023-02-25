package sorteio.controller;

import sorteio.model.Participante;
import sorteio.repository.SorteioRepository;

import java.util.ArrayList;

public class SorteioController implements SorteioRepository {
    ArrayList<Participante> listaParticipantes= new ArrayList<>();
    @Override
    public void adicionar(Participante participante) {
        listaParticipantes.add(participante);
        System.out.printf("\nParticipante %s foi adicionado(a) ao sorteio!", participante.getNome());
    }

    //Método para remover por Id
    @Override
    public boolean remover(int id) {
        Participante p1 = buscarPorId(id);
        if (p1 != null){
            listaParticipantes.remove(p1);
            return true;
        }
        System.out.printf("O id informado (%d) não pertence a nenhum participante!", id);
        return false;
    }

    @Override
    public void mostrar() {
        if (this.listaParticipantes.isEmpty()){
            System.out.println("A lista está vazia!");
        }
        else {
            for (Participante lista : this.listaParticipantes){
                System.out.printf("Nome: %s - Id: %d\n",lista.getNome(), lista.getId());
            }
        }
    }
    //Retorna a lista
    public ArrayList<Participante> getListaParticipantes(){
        return this.listaParticipantes;
    }
    //Método para buscar um participante na lista pelo ID
    public Participante buscarPorId(int id){
        for (Participante lista : listaParticipantes){
            if (lista.getId() == id ){
                return lista;
            }
        }
        return null;
    }

}
