import Core.*;


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
        if (step == 2) botThink();
        else
            while (!checkCanMove(x, y)) {
            }
        boardStage[x][y] = step;
        this.x = x;
        this.y = y;
        step = step == 1 ? 2 : 1;

    }

    public PlayervsBot()  {
        super();
    }

    public static PlayervsBot getInstance() {
        if (instance == null)
                instance =  new PlayervsBot();
        return instance;
    }

    public static void main(String[] args) {
        PlayervsBot playervsBot = PlayervsBot.getInstance();
        playervsBot.actionGame();

    }
}