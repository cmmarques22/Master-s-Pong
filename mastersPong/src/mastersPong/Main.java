package mastersPong;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Picture pictureEnter = new Picture(300, 134.5, "initialScream.png");
        Game game = new Game();
        EventHandlerEnter entHandlerEnter = new EventHandlerEnter(pictureEnter, game);
        entHandlerEnter.initEnter();
        game.init();
        pictureEnter.draw();
        game.move();
    }
}

