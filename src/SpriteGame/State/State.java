package SpriteGame.State;

import SpriteGame.Game;
import SpriteGame.GameInterFace;

public abstract class State implements GameInterFace  {
    public Game game;
    public State(Game game) {
        this.game = game;
    }

}
