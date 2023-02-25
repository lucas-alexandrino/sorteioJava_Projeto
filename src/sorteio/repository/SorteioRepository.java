package sorteio.repository;

import sorteio.model.Participante;

public interface SorteioRepository {
    void adicionar(Participante participante);
    boolean remover(int id);
    void mostrar();

}
