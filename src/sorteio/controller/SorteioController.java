package sorteio.controller;

import sorteio.model.Participante;
import sorteio.repository.SorteioRepository;
import java.util.ArrayList;

public class SorteioController implements SorteioRepository {
    ArrayList<Participante> listaParticipantes= new ArrayList<>();

    //Método para adicionar participante na lista
    @Override
    public void adicionar(Participante participante) {
        this.listaParticipantes.add(participante);
        System.out.printf("\nParticipante %s foi adicionado(a) ao sorteio!", participante.getNome());
    }

    //Método para remover por ID
    @Override
    public boolean remover(int id) {
        Participante participante = buscarPorId(id);
        if (participante != null){
            this.listaParticipantes.remove(participante);
            return true;
        }
        System.out.printf("\nO id informado (%d) não pertence a nenhum participante!\n", id);
        return false;
    }

    //Método para mostrar a lista
    @Override
    public void mostrar() {
        if (this.listaParticipantes.isEmpty()){
            System.out.println("\nA lista está vazia!");
        }
        else {
            for (Participante lista : this.listaParticipantes){
                System.out.printf("NOME: %s - ID: %d",lista.getNome(), lista.getId());
                System.out.println();
            }
        }
    }

    //Método que retorna a lista
    public ArrayList<Participante> getListaParticipantes(){
        return this.listaParticipantes;
    }

    //Método para buscar um participante na lista pelo ID
    public Participante buscarPorId(int id){
        for (Participante lista : this.listaParticipantes){
            if (lista.getId() == id ){
                return lista;
            }
        }
        return null;
    }
    public boolean verificarId(int id){
        for (Participante lista : this.listaParticipantes){
            if (lista.getId() == id){
                return true;
            }
        }
        return false;
    }
    public Integer tamanhoLista(){
       return this.listaParticipantes.size() + 1;
    }
}
