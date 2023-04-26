package mastersPong;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EventHandlerEnter implements KeyboardHandler {

    Picture pictureInitial;
    Game game;
    public static boolean deleted;

    public EventHandlerEnter(Picture pictureInitial, Game game) {

        this.pictureInitial = pictureInitial;
        this.game = game;
    }

    public void initEnter() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_ENTER);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(clear);

        KeyboardEvent restartAll = new KeyboardEvent();
        restartAll.setKey(KeyboardEvent.KEY_ESC);
        restartAll.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(restartAll);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_ENTER -> {
                deleted = true;
                pictureInitial.delete();
                game.drawLifesPL();
                game.drawLifesPR();
            }
            case KeyboardEvent.KEY_ESC -> {
                if (game.player1Wins != null) {
                    game.player1Wins.delete();
                }
                if (game.player2Wins != null) {
                    game.player2Wins.delete();
                }
                if (game.backGroundFinalGame != null) {
                    game.backGroundFinalGame.delete();
                }
                game.deleteLifesPL();
                game.deleteLifesPR();
                pictureInitial.draw();
                game.golsRight = 0;
                game.golsLeft = 0;
                game.leftOrRightDirection = 0.6;
                game.upOrDownDirection = 0.2;
                game.count = 0;
                deleted = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}