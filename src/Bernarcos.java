public class Bernarcos extends Colega {

    private boolean modoFuria;

    public Bernarcos() {
        // Chamando o construtor de Colega com atributos de Boss (bem mais altos)
        super("Bernarcos, O Implacável", 250, 100, 25, 20, 22, "Exception Devastadora");
        this.modoFuria = false;

        // Um boss pode ter 4 ataques liberados desde o início
        this.setAcao(0, "Soco Pesado");
        this.setAcao(1, "Chute de Breakpoint");
        this.setAcao(2, "Reprovação Direta");
        this.setAcao(3, "Exception Devastadora");
    }

    // Sobrescrevendo o método receberDano para criar a mecânica de Fase 2
    @Override
    public void receberDano(int dano) {
        super.receberDano(dano); // Executa o dano normal da classe mãe

        // Mecânica de Boss: Se o HP cair para 50% ou menos, ele entra em Fúria
        if (this.getHpAtual() <= (this.getHpMaximo() / 2) && !this.modoFuria) {
            this.modoFuria = true;
            System.out.println("\n🔥 O céu escurece... Bernarcos entrou em MODO FÚRIA! Seus ataques estão mais letais! 🔥");
            // Nota: Para aumentar o ataque dele aqui, precisaríamos de um método setAtaque() na classe Personagem
        }
    }

    // Tela de status imponente de Boss
    @Override
    public void exibirStatus() {
        System.out.println("=====================================");
        System.out.println(" 👹 BOSS: " + getNome());
        System.out.println(" ❤️ HP: " + getHpAtual() + " / " + getHpMaximo());

        if (modoFuria) {
            System.out.println(" 💢 STATUS: ENFURECIDO (Ataque Aumentado!)");
        }
        System.out.println("=====================================\n");
    }
}