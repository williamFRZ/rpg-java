public class Colega extends Personagem {

    private String poderEspecial;

    public Colega(String nome, int hpMaximo, int energia, int ataque, int defesa, int velocidade, String poderEspecial) {
        super(nome, hpMaximo, energia, ataque, defesa, velocidade);
        this.poderEspecial = poderEspecial;

        this.setAcao(0, "Soco");
        this.setAcao(1, "Chute");
        this.setAcao(2, this.poderEspecial);
        this.setAcao(3, "- Vazio -");
    }

    @Override
    public void exibirStatus() {
        System.out.println("-------------------------------------");
        System.out.println(" 💻 ADVERSÁRIO: " + getNome() + " | Nível: " + getNivel());
        System.out.println(" ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());
        System.out.println(" ⚡ Energia: " + getEnergia());

        System.out.println(" ⚔️ Ações do Colega:");
        String[] acoes = getAcoes();
        for (int i = 0; i < acoes.length; i++) {
            if (!acoes[i].equals("- Vazio -")) {
                System.out.println("    [" + (i + 1) + "] " + acoes[i]);
            }
        }
        System.out.println("-------------------------------------\n");
    }
}