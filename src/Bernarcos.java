public class Bernarcos extends Colega {

    private boolean modoFuria;

    public Bernarcos() {
        super("Bernarcos, O Implacável", 250, 100, 25, 20, 22, "Exception Devastadora");
        this.modoFuria = false;

        this.setAcao(0, new Ataque("Soco Pesado", 90, 20));
        this.setAcao(1, new Ataque("Chute de Breakpoint", 85, 25));
        this.setAcao(2, new Ataque("Reprovação Direta", 75, 35));
        this.setAcao(3, new Ataque("Exception Devastadora", 60, 55));
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