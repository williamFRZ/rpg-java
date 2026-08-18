public class Principal extends Personagem {

    private String curso;
    private String especial;
    private boolean especialDesbloqueado;

    public Principal(String nome, String curso, String especial, int hpMaximo, int energia, int ataque, int defesa, int velocidade) {
        super(nome, hpMaximo, energia, ataque, defesa, velocidade);
        this.curso = curso;
        this.especial = especial;
        this.especialDesbloqueado = false;

        this.setAcao(0, new Ataque("Peteleco", 95, 10));
        this.setAcao(1, new Ataque("Chute", 80, 15));
        this.setAcao(2, new Ataque("- Vazio -", 0, 0));

        if (nome.equalsIgnoreCase("Gabriely") || nome.equalsIgnoreCase("Gaby")) {
            System.out.println("\n[Easter Egg] O universo do jogo sorriu! Uma presença especial foi detectada. 🦆❤️");
            this.setAcao(3, new Ataque("Bicada de Pato", 100, 50));
        } else {
            this.setAcao(3, new Ataque("- Vazio -", 0, 0));
        }
    }

    @Override
    public void exibirStatus() {
        System.out.println("=====================================");
        System.out.println(" 🎮 JOGADOR: " + getNome() + " | Curso: " + this.curso);
        System.out.println(" 📈 Nível: " + getNivel() + " | ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());
        System.out.println(" ⚡ Energia: " + getEnergia());

        System.out.println(" ⚔️ Ações disponíveis:");
        Ataque[] acoes = getAcoes();
        for (int i = 0; i < acoes.length; i++) {
            if (acoes[i] != null && !acoes[i].getNome().equals("- Vazio -")) {
                System.out.println("    [" + (i + 1) + "] " + acoes[i].getNome() + " (Poder: " + acoes[i].getPoder() + " | Precisão: " + acoes[i].getPrecisao() + "%)");
            }
        }
        System.out.println("=====================================\n");
    }

    public void subirNivel() {
        setNivel(getNivel() + 1);
        System.out.println("\n🌟 " + getNome() + " subiu para o nível " + getNivel() + "!");

        if (!especialDesbloqueado && getNivel() >= 3) {
            this.especialDesbloqueado = true;
            this.setAcao(2, new Ataque(this.especial, 80, 30));
            System.out.println("🔓 NOVO PODER DESBLOQUEADO: " + this.especial + "!");
        }

        Ataque[] acoes = getAcoes();
        System.out.println("💪 Seus ataques ficaram mais fortes!");

        for (int i = 0; i < acoes.length; i++) {
            Ataque ataqueAtual = acoes[i];

            if (ataqueAtual != null && !ataqueAtual.getNome().equals("- Vazio -")) {
                int poderAntigo = ataqueAtual.getPoder();
                ataqueAtual.fortalecer();
                System.out.println("   -> " + ataqueAtual.getNome() + " (Poder: " + poderAntigo + " >>> " + ataqueAtual.getPoder() + ")");
            }
        }
    }
}