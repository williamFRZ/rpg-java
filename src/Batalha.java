import java.util.Random;
import java.util.Scanner;

    public class Batalha {

        private Personagem heroi;
        private Personagem inimigo;
        private Scanner scanner;
        private Random random;

        public Batalha(Personagem heroi, Personagem inimigo) {
            this.heroi = heroi;
            this.inimigo = inimigo;
            this.scanner = new Scanner(System.in);
            this.random = new Random();
        }

        public void iniciar() {
            System.out.println("\n⚔️ BATALHA INICIADA! ⚔️");
            System.out.println(heroi.getNome() + " VS " + inimigo.getNome() + "\n");

            while (heroi.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {

                System.out.println("=====================================");
                System.out.println("🦸 " + heroi.getNome() + " [HP: " + heroi.getHpAtual() + "/" + heroi.getHpMaximo() + "]");
                System.out.println("👹 " + inimigo.getNome() + " [HP: " + inimigo.getHpAtual() + "/" + inimigo.getHpMaximo() + "]");
                System.out.println("=====================================");

                int escolhaJogador = escolherAtaqueJogador();
                int escolhaInimigo = escolherAtaqueInimigo();

                System.out.println("\n--- RESOLUÇÃO DO TURNO ---");

                if (heroi.getVelocidade() >= inimigo.getVelocidade()) {
                    heroi.atacar(inimigo, escolhaJogador);
                    if (inimigo.getHpAtual() > 0) {
                        inimigo.atacar(heroi, escolhaInimigo);
                    }
                } else {
                    inimigo.atacar(heroi, escolhaInimigo);
                    if (heroi.getHpAtual() > 0) {
                        heroi.atacar(inimigo, escolhaJogador);
                    }
                }

                if (heroi.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {
                    System.out.println("\nPressione ENTER para o próximo turno...");
                    scanner.nextLine();
                }
            }

            if (heroi.getHpAtual() > 0) {
                System.out.println("\n🏆 VITÓRIA! " + heroi.getNome() + " derrotou " + inimigo.getNome() + "!");
            } else {
                System.out.println("\n💀 GAME OVER! " + inimigo.getNome() + " amassou você.");
            }
        }

        private int escolherAtaqueJogador() {
            Ataque[] acoes = heroi.getAcoes();
            int escolha = -1;
            boolean escolhaValida = false;

            while (!escolhaValida) {
                System.out.println("\nSua vez! Escolha seu ataque:");
                for (int i = 0; i < acoes.length; i++) {
                    if (acoes[i] != null && !acoes[i].getNome().equals("- Vazio -")) {
                        System.out.println("[" + (i + 1) + "] " + acoes[i].getNome() + " (Poder: " + acoes[i].getPoder() + ")");
                    }
                }
                System.out.print("Sua ação: ");

                try {
                    String entrada = scanner.nextLine();
                    escolha = Integer.parseInt(entrada) - 1;

                    if (escolha >= 0 && escolha < 4 && acoes[escolha] != null && !acoes[escolha].getNome().equals("- Vazio -")) {
                        escolhaValida = true;
                    } else {
                        System.out.println("⚠️ Opção inválida! Escolha um ataque disponível.");
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ Digite um número válido!");
                }
            }
            return escolha;
        }

        private int escolherAtaqueInimigo() {
            Ataque[] acoes = inimigo.getAcoes();
            int escolha;

            do {
                escolha = random.nextInt(4);
            } while (acoes[escolha] == null || acoes[escolha].getNome().equals("- Vazio -"));

            return escolha;
        }
    }

