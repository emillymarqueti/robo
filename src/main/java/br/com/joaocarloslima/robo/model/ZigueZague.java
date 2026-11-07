package br.com.joaocarloslima.robo.model;

public class ZigueZague implements Rota {

    private Direcao horizontal = Direcao.DIREITA;

    @Override
    public String getNome() {
        return "Zigue-zague";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {

        if (sala.livre(atual.mover(horizontal))) {
            return horizontal;
        }

        if (horizontal == Direcao.DIREITA) {
            horizontal = Direcao.ESQUERDA;
        } else {
            horizontal = Direcao.DIREITA;
        }

        if (sala.livre(atual.mover(Direcao.BAIXO))) {
            return Direcao.BAIXO;
        }

        if (sala.livre(atual.mover(Direcao.CIMA))) {
            return Direcao.CIMA;
        }

        return horizontal;
    }
}
