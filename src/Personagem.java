public abstract class Personagem {

    private String nome;
    private int nivel;

    private int hpAtual;
    private int hpMaximo;
    private int energia;       // Adicionado para receber o valor do construtor

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

    public void receberDano(int dano) {
        this.hpAtual -= dano;
        if (this.hpAtual < 0) {
            this.hpAtual = 0;
        }
    }
    public void setAcao(int indice, String acao) {
        if(indice >= 0 && indice < 4) {
            this.acoes[indice] = acao;
        }
    }

    public String[] getAcoes() {
        return acoes;
    }

    public abstract void exibirStatus();
}