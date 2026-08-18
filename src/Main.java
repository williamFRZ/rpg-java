import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("         RPG DO WILLIAM             ");
        System.out.println("=====================================");

        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        if (nome.equalsIgnoreCase("gabriely") || nome.equalsIgnoreCase("gaby")) {
            System.out.println("\nO universo do jogo sorriu! Uma presença especial foi detectada. 🦆❤️");
            System.out.println("Você recebeu um ataque especial: Bicada de Pato!");
        }

        System.out.println("\nEscolha o seu curso:");
        System.out.println("[1] TADS");
        System.out.println("[2] ENG. ELÉTRICA");
        System.out.println("[3] ELETRO");
        System.out.println("[4] INFO");
        System.out.println("[5] SER");
        System.out.println("[6] ADM");
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
                curso = "INFO";
                especial = "atirar tecla enter";
                break;
            case 5:
                curso = "SER";
                especial = "lançamento de cata vento";
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

        Principal aluno = new Principal(nome, curso, especial, 100, 50, 15, 10, 20);

        System.out.println("\nPersonagem criado com sucesso!");
        aluno.exibirStatus();

        System.out.println("\n[O tempo passa...]");
        aluno.subirNivel();
        aluno.subirNivel();

        System.out.println("\n⚠️ BERNARCOS APARECEU NO CORREDOR! ⚠️");
        Bernarcos boss = new Bernarcos();
        boss.exibirStatus();

        System.out.println("\nPressione ENTER para iniciar o combate...");

        scanner.nextLine();
        scanner.nextLine();

        Batalha batalhaContraBoss = new Batalha(aluno, boss);
        batalhaContraBoss.iniciar();

        scanner.close();
    }
}