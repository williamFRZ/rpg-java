import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("     BEM-VINDO AO RPG DE TADS        ");
        System.out.println("=====================================");

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        System.out.println("\nEscolha o seu curso (Define seu poder especial):");
        System.out.println("[1] TADS (Análise e Desenvolvimento de Sistemas)");
        System.out.println("[2] Robótica Educacional");
        System.out.println("[3] Engenharia de Computação");
        System.out.println("[4] Design Gráfico");
        System.out.print("Opção: ");

        int opcaoCurso = scanner.nextInt();
        String curso = "";
        String especial = "";

        switch (opcaoCurso) {
            case 1:
                curso = "TADS";
                especial = "Fúria do Código Limpo";
                break;
            case 2:
                curso = "Robótica Educacional";
                especial = "Curto-Circuito de EV3";
                break;
            case 3:
                curso = "Engenharia de Computação";
                especial = "Sobrecarga de Hardware";
                break;
            case 4:
                curso = "Design Gráfico";
                especial = "Vetor Cortante";
                break;
            default:
                curso = "Aluno Ouvinte";
                especial = "Chute no Escuro";
                break;
        }

        // Instanciando o personagem principal
        Principal heroi = new Principal(nome, curso, especial, 100, 50, 15, 10, 20);

        System.out.println("\nPersonagem criado com sucesso!");
        heroi.exibirStatus();

        // Simulando ganho de níveis para desbloquear o especial
        System.out.println("\n[O tempo passa, muito estudo, muita programação...]");
        heroi.subirNivel(); // Vai pro nível 2
        heroi.subirNivel(); // Vai pro nível 3 e libera o especial!

        System.out.println("\n⚠️ UM CHEFÃO APARECEU NO CORREDOR! ⚠️");
        Bernarcos boss = new Bernarcos();
        boss.exibirStatus();

        System.out.println("\n--- DEMONSTRAÇÃO DE COMBATE ---");

        // O herói ataca o Bernarcos usando o ataque no índice 0 (Peteleco)
        heroi.atacar(boss, 0);

        // O Bernarcos revida atacando o herói com o ataque no índice 0 (Soco Pesado)
        boss.atacar(heroi, 0);

        // Mostrando como ficaram as vidas depois do primeiro turno
        System.out.println("\n--- STATUS APÓS O TURNO 1 ---");
        heroi.exibirStatus();
        boss.exibirStatus();

        scanner.close();
    }
}