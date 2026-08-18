import java.util.Random;

public abstract class Personagem {

    private String nome;
    private int nivel;

    private int hpAtual;
    private int hpMaximo;
    private int energia;

    private int ataque;
    private int defesa;
    private int velocidade;

    private Ataque[] acoes;

    public Personagem(String nome, int hpMaximo, int energia, int ataque, int defesa, int velocidade) {
        this.nome = nome;
        this.nivel = 1;
        this.hpMaximo = hpMaximo;
        this.hpAtual = hpMaximo;
        this.energia = energia;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.acoes = new Ataque[4];
    }

    public String getNome() { return nome; }
    public int getNivel() { return nivel; }
    public int getHpAtual() { return hpAtual; }
    public int getHpMaximo() { return hpMaximo; }
    public int getEnergia() { return energia; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getVelocidade() { return velocidade; }
    public Ataque[] getAcoes() { return acoes; }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setAcao(int indice, Ataque ataque) {
        if(indice >= 0 && indice < 4) {
            this.acoes[indice] = ataque;
        }
    }

    public void receberDano(int dano) {
        this.hpAtual -= dano;
        if (this.hpAtual < 0) {
            this.hpAtual = 0;
        }
    }

    public void atacar(Personagem alvo, int indiceAtaque) {
        Ataque ataqueUsado = this.acoes[indiceAtaque];

        if (ataqueUsado == null || ataqueUsado.getNome().equals("- Vazio -")) {
            System.out.println("Ataque inválido!");
            return;
        }

        System.out.println("\n⚔️ " + this.nome + " usou " + ataqueUsado.getNome() + "!");

        Random random = new Random();
        int sorteio = random.nextInt(100) + 1;

        if (sorteio <= ataqueUsado.getPrecisao()) {
            int danoBruto = this.ataque + ataqueUsado.getPoder();
            int danoFinal = danoBruto - alvo.getDefesa();

            if (danoFinal < 1) {
                danoFinal = 1;
            }

            System.out.println("💥 Acertou! Causou " + danoFinal + " de dano em " + alvo.getNome() + ".");
            alvo.receberDano(danoFinal);
        } else {
            System.out.println("❌ O ataque falhou! " + this.nome + " errou o golpe.");
        }
    }

    public abstract void exibirStatus();
}