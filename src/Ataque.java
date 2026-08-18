public class Ataque {

    private String nome;
    private int precisao;
    private int poder;

    public Ataque(String nome, int precisao, int poder) {
        this.nome = nome;
        this.precisao = precisao;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPrecisao() {
        return precisao;
    }

    public int getPoder() {
        return poder;
    }

    public void fortalecer() {
        int aumento = (int) (this.poder * 0.05);
        if (aumento == 0) {
            aumento = 1;
        }
        this.poder += aumento;
    }
}