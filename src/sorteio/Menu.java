package sorteio;

import sorteio.controller.SorteioController;
import sorteio.model.Participante;
import sorteio.model.Sorteio;
import sorteio.model.SorteioAbertura;
import sorteio.model.SorteioPitch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SorteioController sorteioController = new SorteioController();
        Sorteio abertura = new SorteioAbertura();
        Sorteio pitch = new SorteioPitch();

        int opcaoEscolhida;

        try {
            while (true) {
                System.out.println("                                                     ");
                System.out.println("                SORTEIO: DUPLAS ABERTURA & PITCH     ");
                System.out.println("                                                     ");
                System.out.println("-----------------------------------------------------");
                System.out.println("                                                     ");
                System.out.println("            1 - Adicionar participantes!             ");
                System.out.println("            2 - Mostrar participantes...             ");
                System.out.println("            3 - Remover participantes...             ");
                System.out.println("            4 - Realizar Sorteio                     ");
                System.out.println("            5 - Sair                                 ");
                System.out.println("                                                     ");
                System.out.println("-----------------------------------------------------");

                System.out.print("Entre com a opção desejada: ");
                opcaoEscolhida = input.nextInt();

                if (opcaoEscolhida == 5) {
                    System.out.println("\nObrigada por utilizar nosso programa de sorteio!");
                    input.close();
                    System.exit(0);
                }
                switch (opcaoEscolhida) {
                    case 1:
                        System.out.println("\nQuantos participantes serão?");
                        System.out.print("-> ");
                        int numeroParticipantes = input.nextInt();
                        input.nextLine();

                        System.out.println("\nDigite o NOME e o ID do participante!");
                        for (int i = 0; i < numeroParticipantes; i++) {
                            System.out.printf("\nNOME PARTICIPANTE %d-> ", i + 1);
                            String nome = input.nextLine();

                            System.out.print("ID ->");
                            int id = input.nextInt();
                            input.nextLine();
                            sorteioController.adicionar(new Participante(nome, id));
                            System.out.println();
                        }
                        break;

                    case 2:
                        System.out.println("\nLista de partcipantes: ");
                        sorteioController.mostrar();
                        break;

                    case 3:
                        System.out.println("\nDigite o ID correpondente ao participante para removê-lo: ");
                        int idParticipante = input.nextInt();
                        //método remover da classe SorteioCollor, remover um elemento da lista pelo id
                        boolean participanteRemovido = sorteioController.remover(idParticipante);
                        if (participanteRemovido) {
                            System.out.println("\nO participante foi removido com sucesso!");
                        }
                        break;
                    case 4:
                        System.out.println("\nVamos realizar o sorteio!");
                        System.out.println("\nEscolha uma opção: ");
                        System.out.println("\nPara SORTEIO DUPLA ABERTURA -> Digite 1 ");
                        System.out.println("Para SORTEIO DUPLA PITCH -> Digite 2 ");
                        System.out.print("\nOpção escolhida -> ");
                        int opcaoSorteio = input.nextInt();

                        while (opcaoSorteio != 1 && opcaoSorteio != 2){
                            System.out.println("\nOpção inválida!");
                            System.out.println("\nPara SORTEIO DUPLA ABERTURA -> Digite 1 ");
                            System.out.println("Para SORTEIO DUPLA PITCH -> Digite 2 ");
                            System.out.print("\nOpção escolhida -> ");
                            opcaoSorteio = input.nextInt();
                        }

                        if (opcaoSorteio == 1) {
                            System.out.println("\nA dupla sorteada para a ABERTURA é: ");
                            for (int i = 0; i < 2; i++) {
                                Participante participante = abertura.sortearDuplas(sorteioController.getListaParticipantes());
                                System.out.println(participante.getNome());
                                sorteioController.remover(participante.getId());
                            }
                            abertura.sortearTema();
                        }
                        else {
                            System.out.println("\nA dupla sorteada para o PITCH é: ");
                            for (int i = 0; i < 2; i++) {
                                Participante participante = pitch.sortearDuplas(sorteioController.getListaParticipantes());
                                System.out.println(participante.getNome());
                                sorteioController.remover(participante.getId());
                            }
                            System.out.println("\nA dupla sorteada para o FEEDBACK é: ");
                            for (int i = 0; i < 2; i++) {
                                Participante participante = pitch.sortearDuplas(sorteioController.getListaParticipantes());
                                System.out.println(participante.getNome());
                                sorteioController.remover(participante.getId());
                            }
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        break;
                }
            }
         //Tratamento de exceção
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("\nErro de digitação! Digite um número inteiro!");
         //Tratamento de exceção
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("\nSorteio incompleto! A lista está vazia ou não contém participantes o suficiente!");
        }
    }
}

