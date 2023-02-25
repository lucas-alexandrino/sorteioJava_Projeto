package sorteio.model;

public class Participante {
    private String nome;
    private int id;

    public Participante(String nome, int numeroParticipante) {
        this.nome = nome;
        this.id = numeroParticipante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
