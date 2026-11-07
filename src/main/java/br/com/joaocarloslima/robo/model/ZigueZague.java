package br.com.joaocarloslima.robo.model;

public class ZigueZague implements Rota {

    private Direcao horizontal = Direcao.DIREITA;
    private Direcao vertical = Direcao.BAIXO;

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

        if (!sala.livre(atual.mover(vertical))) {
            if (vertical == Direcao.BAIXO) {
                vertical = Direcao.CIMA;
            } else {
                vertical = Direcao.BAIXO;
            }
        }

        if (sala.livre(atual.mover(vertical))) {
            return vertical;
        }

        return horizontal;
    }
}