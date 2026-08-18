public class Colega extends Personagem {

    private String nomePoderEspecial;

    public Colega(String nome, int hpMaximo, int energia, int ataque, int defesa, int velocidade, String nomePoderEspecial) {
        super(nome, hpMaximo, energia, ataque, defesa, velocidade);
        this.nomePoderEspecial = nomePoderEspecial;

        this.setAcao(0, new Ataque("Soco", 90, 12));
        this.setAcao(1, new Ataque("Chute", 85, 18));
        this.setAcao(2, new Ataque(this.nomePoderEspecial, 75, 35));
        this.setAcao(3, new Ataque("- Vazio -", 0, 0));
    }

    @Override
    public void exibirStatus() {
        System.out.println("-------------------------------------");
        System.out.println(" 💻 ADVERSÁRIO: " + getNome() + " | Nível: " + getNivel());
        System.out.println(" ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());
        System.out.println(" ⚡ Energia: " + getEnergia());

        System.out.println(" ⚔️ Ações do Colega:");
        Ataque[] acoes = getAcoes();
        for (int i = 0; i < acoes.length; i++) {
            if (acoes[i] != null && !acoes[i].getNome().equals("- Vazio -")) {
                System.out.println("    [" + (i + 1) + "] " + acoes[i].getNome() + " (Poder: " + acoes[i].getPoder() + " | Precisão: " + acoes[i].getPrecisao() + "%)");
            }
        }
        System.out.println("-------------------------------------\n");
    }
}