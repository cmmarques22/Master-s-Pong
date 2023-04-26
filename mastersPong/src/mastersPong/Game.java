package mastersPong;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    Rectangle rectangleLeft;
    Rectangle rectangleRight;
    EventHandlerLeft handlerLeft;
    EventHandlerRight handlerRight;
    double leftOrRightDirection = 0.6;
    double upOrDownDirection = 0.2;
    int count;
    public int golsLeft = 0;
    public int golsRight = 0;

    Picture backGroundFire;
    Picture picture;
    Picture pictureBall;
    Picture backGroundFinalGame;
    Picture player1Wins;
    Picture player2Wins;

    //Life balls and Lost lifes for player left and player right
    Picture life1PL;
    Picture life2PL;
    Picture life3PL;
    Picture life4PL;
    Picture life5PL;
    Picture life1PR;
    Picture life2PR;
    Picture life3PR;
    Picture life4PR;
    Picture life5PR;

    Picture lostLife1PL;
    Picture lostLife2PL;
    Picture lostLife3PL;
    Picture lostLife4PL;
    Picture lostLife5PL;

    Picture lostLife1PR;
    Picture lostLife2PR;
    Picture lostLife3PR;
    Picture lostLife4PR;
    Picture lostLife5PR;

    //creates players Lifes and Lost Lifes
    public void createLifesPL() {
        life1PL = new Picture(200, 30, "Aldino.png");
        life2PL = new Picture(245, 30, "Carol.png");
        life3PL = new Picture(290, 30, "Ferrao.png");
        life4PL = new Picture(335, 30, "Joao.png");
        life5PL = new Picture(380, 30, "Miguel.png");
    }

    public void createLostLifesPL() {
        lostLife1PL = new Picture(200, 30, "Aldino_Lost.png");
        lostLife2PL = new Picture(245, 30, "Carol_Lost.png");
        lostLife3PL = new Picture(290, 30, "Ferrao_Lost.png");
        lostLife4PL = new Picture(335, 30, "Joao_Lost.png");
        lostLife5PL = new Picture(380, 30, "Miguel_Lost.png");
    }

    public void createLifesPR() {
        life1PR = new Picture(1120, 30, "Nuno.png");
        life2PR = new Picture(1165, 30, "Raquel.png");
        life3PR = new Picture(1210, 30, "Rolo.png");
        life4PR = new Picture(1255, 30, "Rolo2.png");
        life5PR = new Picture(1300, 30, "Zuca.png");
    }

    public void createLostLifesPR() {
        lostLife1PR = new Picture(1120, 30, "Nuno_Lost.png");
        lostLife2PR = new Picture(1165, 30, "Raquel_Lost.png");
        lostLife3PR = new Picture(1210, 30, "Rolo_Lost.png");
        lostLife4PR = new Picture(1255, 30, "Rolo2_Lost.png");
        lostLife5PR = new Picture(1300, 30, "Zuca_Lost.png");
    }

    // draws the initial amount of lifes for the players
    public void drawLifesPL() {
        life1PL.draw();
        life2PL.draw();
        life3PL.draw();
        life4PL.draw();
        life5PL.draw();
    }

    public void drawLifesPR() {
        life1PR.draw();
        life2PR.draw();
        life3PR.draw();
        life4PR.draw();
        life5PR.draw();
    }

    // draws the reduced amount of lives and the lost lifes when the player loses one or more lifes
    public void draw4LifesPL() {

        life1PL.draw();
        life2PL.draw();
        life3PL.draw();
        life4PL.draw();
        lostLife5PL.draw();
    }

    public void draw3LifesPL() {
        life1PL.draw();
        life2PL.draw();
        life3PL.draw();
        lostLife4PL.draw();
        lostLife5PL.draw();
    }

    public void draw2LifesPL() {
        life1PL.draw();
        life2PL.draw();
        lostLife3PL.draw();
        lostLife4PL.draw();
        lostLife5PL.draw();
    }

    public void draw1LifesPL() {
        life1PL.draw();
        lostLife2PL.draw();
        lostLife3PL.draw();
        lostLife4PL.draw();
        lostLife5PL.draw();
    }

    public void draw0LifesPL() {
        lostLife1PL.draw();
        lostLife2PL.draw();
        lostLife3PL.draw();
        lostLife4PL.draw();
        lostLife5PL.draw();
    }

    public void draw4LifesPR() {
        lostLife1PR.draw();
        life2PR.draw();
        life3PR.draw();
        life4PR.draw();
        life5PR.draw();
    }

    public void draw3LifesPR() {
        lostLife1PR.draw();
        lostLife2PR.draw();
        life3PR.draw();
        life4PR.draw();
        life5PR.draw();
    }

    public void draw2LifesPR() {
        lostLife1PR.draw();
        lostLife2PR.draw();
        lostLife3PR.draw();
        life4PR.draw();
        life5PR.draw();
    }

    public void draw1LifesPR() {
        lostLife1PR.draw();
        lostLife2PR.draw();
        lostLife3PR.draw();
        lostLife4PR.draw();
        life5PR.draw();
    }

    public void draw0LifesPR() {
        lostLife1PR.draw();
        lostLife2PR.draw();
        lostLife3PR.draw();
        lostLife4PR.draw();
        lostLife5PR.draw();
    }

    // Deletes all lifes and lost Lifes so we can redraw the amount of lives we need when the player loses 1 or more lifes
    public void deleteLifesPL() {
        life1PL.delete();
        life2PL.delete();
        life3PL.delete();
        life4PL.delete();
        life5PL.delete();
        lostLife1PL.delete();
        lostLife2PL.delete();
        lostLife3PL.delete();
        lostLife4PL.delete();
        lostLife5PL.delete();
    }

    public void deleteLifesPR() {
        life1PR.delete();
        life2PR.delete();
        life3PR.delete();
        life4PR.delete();
        life5PR.delete();
        lostLife1PR.delete();
        lostLife2PR.delete();
        lostLife3PR.delete();
        lostLife4PR.delete();
        lostLife5PR.delete();
    }

    public void init() {

        createLostLifesPL();
        createLostLifesPR();
        createLifesPL();
        createLifesPR();

//        CRIA CAMPO DE JOGO
        backGroundFire = new Picture(0, 0, "backgroundFire.png");
        picture = new Picture(100, 0, "fieldAdeC.png");
//        CRIA BOLA
        pictureBall = new Picture(680, 300, "bolaDeFutebol3.png");

//        CRIA RETANGULOS ESQUERDO E DIREITO E INICIA EVENTO DE CLIQUE DE TECLADO
        rectangleLeft = new Rectangle(110, 365, 30, 120);
        rectangleRight = new Rectangle(1460, 365, 30, 120);
        handlerLeft = new EventHandlerLeft(rectangleLeft);
        handlerRight = new EventHandlerRight(rectangleRight);
        handlerRight.initRight();
        handlerLeft.initLeft();

//        FAZ APARECER O CAMPO E A BOLA
        backGroundFire.draw();
        picture.draw();
        pictureBall.draw();
        pictureBall.grow(-80, -80);

        // Initiates Player Left and Player Right 5 Lifes

//        FAZ APARECER OS RETANGULOS
        rectangleLeft.setColor(Color.WHITE);
        rectangleRight.setColor(Color.WHITE);
        rectangleLeft.fill();
        rectangleRight.fill();
    }


    public void move() throws InterruptedException {

        while (golsLeft < 5 || golsRight < 5) {

//            FAZ A BOLA SE MOVER
            Thread.sleep(1);
            if (EventHandlerEnter.deleted) {
                pictureBall.translate(leftOrRightDirection, upOrDownDirection);
            }
//            SE BATER NA BARRA DIREITA
            if (pictureBall.getX() == rectangleRight.getX() - pictureBall.getWidth()) {
                if (pictureBall.getY() > rectangleRight.getY() - 70 && pictureBall.getY() < rectangleRight.getY() + rectangleRight.getHeight() + 40) {
                    invertDirection();
                    count++;
                }
            }
//            SE BATER NA BARRA ESQUERDA
            if (pictureBall.getX() == rectangleLeft.getX() + 30) {
                if (pictureBall.getY() + pictureBall.getWidth() > rectangleLeft.getY() - 40
                        && pictureBall.getY() + pictureBall.getWidth() < rectangleLeft.getY() + rectangleLeft.getHeight() + 70) {
                    invertDirection();
                    count++;
                }
            }
//            SE BATER EM CIMA OU EM BAIXO
            if (pictureBall.getY() == picture.getHeight() - pictureBall.getHeight()) {

//                EM BAIXO
                int random = (int) (Math.random() * 6);
                if (random == 0) {
                    upOrDownDirection = 0.5;
                } else if (random == 1) {
                    upOrDownDirection = 0.4;
                } else if (random == 2) {
                    upOrDownDirection = 0.3;
                } else if (random == 3) {
                    upOrDownDirection = 0.2;
                }
                invertUpOrDown();
            }
//           EM CIMA
            if (pictureBall.getY() == 0) {
                int random2 = (int) (Math.random() * 6);

                if (random2 == 0) {
                    upOrDownDirection = -0.5;
                } else if (random2 == 1) {
                    upOrDownDirection = -0.4;
                } else if (random2 == 2) {
                    upOrDownDirection = -0.3;
                } else if (random2 == 3) {
                    upOrDownDirection = -0.2;
                }
                invertUpOrDown();
            }

//            SE A BOLA ENTRAR NO LADO DIREITO
            if (pictureBall.getX() == backGroundFire.getWidth() - pictureBall.getWidth()
                    || pictureBall.getX() == backGroundFire.getWidth() - pictureBall.getWidth() - 5
                    || pictureBall.getX() == backGroundFire.getWidth() - pictureBall.getWidth() - 10) {
                golsLeft++;
                pictureBall.delete();
                if (golsLeft == 1) {
                    deleteLifesPR();
                    draw4LifesPR();
                    restart();
                } else if (golsLeft == 2) {
                    deleteLifesPR();
                    draw3LifesPR();
                    restart();
                } else if (golsLeft == 3) {
                    deleteLifesPR();
                    draw2LifesPR();
                    restart();
                } else if (golsLeft == 4) {
                    deleteLifesPR();
                    draw1LifesPR();
                    restart();
                } else if (golsLeft == 5) {
                    deleteLifesPR();
                    draw0LifesPR();
                    backGroundFinalGame = new Picture(300, 134.5, "backGroundFinalGame.png");
                    player1Wins = new Picture(380, 295, "player1Wins.png");
                    backGroundFinalGame.draw();
                    player1Wins.draw();
                }
            }

//            SE A BOLA ENTRAR NO LADO ESQUERDO
            if (pictureBall.getX() == backGroundFire.getWidth() - backGroundFire.getWidth()
                    || pictureBall.getX() == backGroundFire.getWidth() - backGroundFire.getWidth() + 5
                    || pictureBall.getX() == backGroundFire.getWidth() - backGroundFire.getWidth() + 10) {
                golsRight++;
                pictureBall.delete();
                if (golsRight == 1) {
                    deleteLifesPL();
                    draw4LifesPL();
                    restart();
                } else if (golsRight == 2) {
                    deleteLifesPL();
                    draw3LifesPL();
                    restart();
                } else if (golsRight == 3) {
                    deleteLifesPL();
                    draw2LifesPL();
                    restart();
                } else if (golsRight == 4) {
                    deleteLifesPL();
                    draw1LifesPL();
                    restart();
                } else if (golsRight == 5) {
                    deleteLifesPL();
                    draw0LifesPL();
                    backGroundFinalGame = new Picture(300, 134.5, "backGroundFinalGame.png");
                    player2Wins = new Picture(380, 295, "player2Wins.png");
                    backGroundFinalGame.draw();
                    player2Wins.draw();
                }
            }

//            AUMENTA A VELOCIDADE COM O PASSAR DO JOGO
            switch (count) {
                case 2 -> leftOrRightDirection = 0.8;
                case 6 -> leftOrRightDirection = 1;
                case 18 -> leftOrRightDirection = 1.2;
            }

//            SE O JOGADOR ESQUERDO OU DIREITO VENCER
            if (golsLeft == 5 || golsRight == 5) {
                pictureBall.delete();
                break;
            }
        }
        golsRight = 0;
        golsLeft = 0;
        EventHandlerEnter.deleted = false;
        pictureBall.delete();
        restart();
        move();
    }

    public void restart() {
        pictureBall = new Picture(700, 300, "bolaDeFutebol3.png");
        pictureBall.draw();
        pictureBall.grow(-80, -80);
        invertDirection();
        invertUpOrDown();
    }

    public void invertDirection() {
        leftOrRightDirection *= -1;
    }

    public void invertUpOrDown() {

        upOrDownDirection *= -1;
    }
}

