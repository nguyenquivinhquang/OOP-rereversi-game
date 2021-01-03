package Core;

import GUI.Render;

import java.util.concurrent.TimeUnit;


public class PlayervsBot extends PlayerVsPlayer {
    private static PlayervsBot instance = null;

    private void botThink() {
        Minimax move = Minimax.getInstance();
        cond temp = move.getOptimalMove(boardStage, this.x, this.y);
        this.x = temp.x;
        this.y = temp.y;
        System.out.println("bot move: " + this.x + " " + this.y);

    }

    public void press() {
        if (step == 2) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            botThink();
        } else
            while (!checkCanMove(x, y)) {
            }
        boardStage[x][y] = step;
        this.x = x;
        this.y = y;
        step = step == 1 ? 2 : 1;

    }

    protected PlayervsBot() {
        super();
    }

    public static PlayervsBot getInstance() {
        if (instance == null)
            instance = new PlayervsBot();
        return instance;
    }
}