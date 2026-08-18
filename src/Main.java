import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("     RPG DO WILLIÃO        ");
        System.out.println("=====================================");

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        if (nome.equalsIgnoreCase("gabriely") || nome.equalsIgnoreCase("gaby")) {
            System.out.println("\nO universo do jogo sorriu! Uma presença especial foi detectada. 🦆❤️");
            System.out.println("\nVocê recebeu um ataque especial: Bicada de Pato! 🦆❤️");

            System.out.println("\nEscolha o seu curso:");
            System.out.println("[1] TADS");
            System.out.println("[2] ENG. ELÉTRICA");
            System.out.println("[3] ELETRO");
            System.out.println("[4] INFO");
            System.out.println("[5] SER");
            System.out.println("[5] ADM");
            System.out.print("Opção: ");

            int opcaoCurso = scanner.nextInt();
            String curso = "";
            String especial = "";

            switch (opcaoCurso) {
                case 1:
                    curso = "TADS";
                    especial = "vibe code com mega brain";
                    break;
                case 2:
                    curso = "ENG. ELÉTRICA";
                    especial = "explosão de bateria";
                    break;
                case 3:
                    curso = "ELETRO";
                    especial = "jogar microondas com defeito";
                    break;
                case 4:
                    curso = "SER";
                    especial = "lançamento de cata vento";
                    break;
                case 5:
                    curso = "INFO";
                    especial = "atirar tecla enter";
                    break;
                case 6:
                    curso = "ADM";
                    especial = "publi enganosa de vaquinha";
                    break;

                default:
                    curso = "Aluno burro";
                    especial = "Chute no Escuro";
                    break;
            }


            Principal heroi = new Principal(nome, curso, especial, 100, 50, 15, 10, 20);

            System.out.println("\nPersonagem criado com sucesso!");
            heroi.exibirStatus();

            System.out.println("\n[O tempo passa...]");
            heroi.subirNivel(); // Vai pro nível 2
            heroi.subirNivel(); // Vai pro nível 3 e libera o especial!

            System.out.println("\n⚠️ BERNARCOS APARECEU NO CORREDOR! ⚠️");
            Bernarcos boss = new Bernarcos();
            boss.exibirStatus();

            System.out.println("\n--- DEMONSTRAÇÃO DE COMBATE ---");

            heroi.atacar(boss, 0);

            boss.atacar(heroi, 0);

            System.out.println("\n--- STATUS APÓS O TURNO 1 ---");
            heroi.exibirStatus();
            boss.exibirStatus();

            scanner.close();
        }
    }
}