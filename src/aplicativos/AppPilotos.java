package aplicativos;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao;
        int qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        
       
        String cpf;
        String nome;
        

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");           
            System.out.print("Opção: "); 
            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                

                System.out.print("Digite o nome do Piloto: ");
                nome = in.nextLine();
                System.out.print("Digite o CPF do Piloto: ");
                cpf = in.nextLine();

                Pessoa pilot = new Pessoa(nome);
                System.out.println("\nPiloto " + pilot.getNome() + " cadastrado com sucesso.");
                

                voltarMenu(in);
                

            } else if (opcao == 2) {

                
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                for (int i = 0; i < qtdCadastrados; i++) {
                    
                nome = nome = in.nextLine();    
                Pessoa pilot = new Pessoa(nome);
                System.out.println("**Piloto(s) cadastrados abaixo**");
                System.out.println("Piloto: " + pilot.getNome());

                
                voltarMenu(in);
            
                }   
            } else if (opcao == 3) {

            
                System.out.print("Digite o CPF do Piloto: ");
                cpf = in.nextLine();
                System.out.println("O Piloto encontrado:" + BuscarNomeCpf(""));
            

            } else if (opcao == 4) {

                Pessoa[] vetorArmaz = new Pessoa[10];				
                for (int i = 0; i < qtdCadastrados; i++) {					
                vetorArmaz[i] = pilotos[i];				}
				pilotos = vetorArmaz;				
                MAX_ELEMENTOS = 10;
                System.out.println("Você tem mais Armarzenamento!");
                
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
      
    }

    private static String BuscarNomeCpf(String nome) {
        return nome;
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}