public class Principal extends Personagem {

    private String curso;
    private String especial;
    private boolean especialDesbloqueado;

    public Principal(String nome, String curso, String especial, int hpMaximo, int energia, int ataque, int defesa, int velocidade) {
        super(nome, hpMaximo, energia, ataque, defesa, velocidade);
        this.curso = curso;
        this.especial = especial;
        this.especialDesbloqueado = false;

        this.setAcao(0, new Ataque("Peteleco", 95)); // 95% de chance de acerto
        this.setAcao(1, new Ataque("Chute", 80));    // 80% de chance de acerto
        this.setAcao(2, new Ataque("- Vazio -", 0));

        if (nome.equalsIgnoreCase("Gabriely") || nome.equalsIgnoreCase("Gaby")) {
            System.out.println("\n[Easter Egg] O universo do jogo sorriu! Uma presença especial foi detectada. 🦆❤️");
            // A Bicada de Pato nunca erra! (100% de precisão)
            this.setAcao(3, new Ataque("Bicada de Pato", 100));
        } else {
            this.setAcao(3, new Ataque("- Vazio -", 0));
        }

        if (nome.equalsIgnoreCase("Gabriely") || nome.equalsIgnoreCase("Gaby")) {
            System.out.println("\nO universo do jogo sorriu! Uma presença especial foi detectada. 🦆❤️");
            this.setAcao(3, "Bicada de Pato");
        } else {
            this.setAcao(3, "- Vazio -");
        }
    }

    @Override
    public void exibirStatus() {
        System.out.println("=====================================");
        System.out.println(" 🎮 JOGADOR: " + getNome() + " | Curso: " + this.curso);
        System.out.println(" 📈 Nível: " + getNivel() + " | ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());
        System.out.println(" ⚡ Energia: " + getEnergia());

        System.out.println(" ⚔️ Ações disponíveis:");
        String[] acoes = getAcoes();
        for (int i = 0; i < acoes.length; i++) {
            System.out.println("    [" + (i + 1) + "] " + acoes[i]);
        }
        System.out.println("=====================================\n");
    }

    public void subirNivel() {
        System.out.println("\n🌟 " + getNome() + " subiu de nível!");

        if (!especialDesbloqueado) {
            this.especialDesbloqueado = true;
            this.setAcao(2, this.especial);
            System.out.println("🔓 NOVO PODER DESBLOQUEADO: " + this.especial + "!");
        }
    }
}