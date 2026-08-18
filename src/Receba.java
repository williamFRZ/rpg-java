public class Receba extends Colega {

    private boolean modoFuria;

    public Receba() {
        super("blablabla", 350, 200, 35, 40, 20, "Chá de sumiço");
        this.modoFuria = false;

        this.setAcao(0, new Ataque("Soco Pesado", 90, 20));
        this.setAcao(1, new Ataque("Chamado recusado", 85, 25));
        this.setAcao(2, new Ataque("Derrubar Internet", 75, 35));
        this.setAcao(3, new Ataque("Microfonada", 60, 55));
    }

    @Override
    public void receberDano(int dano) {
        super.receberDano(dano);

        if (this.getHpAtual() <= (this.getHpMaximo() / 2) && !this.modoFuria) {
            this.modoFuria = true;
            System.out.println("\n🔥 O céu escurece... Bernarcos não comeu a Isabela e entrou no modo FÚRIA!");

            Ataque[] acoes = getAcoes();
            for (int i = 0; i < acoes.length; i++) {
                if (acoes[i] != null && !acoes[i].getNome().equals("- Vazio -")) {
                    acoes[i].fortalecer();
                    acoes[i].fortalecer();
                }
            }
        }
    }

    @Override
    public void exibirStatus() {
        System.out.println("=====================================");
        System.out.println(" 👹 BOSS: " + getNome());
        System.out.println(" ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());

        if (modoFuria) {
            System.out.println(" 💢 STATUS: ENFURECIDO");
        }
        System.out.println("=====================================\n");
    }
}