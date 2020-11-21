public class PlayervsBot extends PlayerVsPlayer {

    public void press() {
        int x = 0, y = 0;
        if (step == 1) {
            while (fee[x][y] == -1) {
                cond temp = graphic.getXY();
                x = temp.x;
                y = temp.y;
                int check = checkCanMove(x, y);
                if (check != 0)
                    graphic.warning(check);
                else fee[x][y] = step;
            }
            this.x = x;
            this.y = y;
            step = 2;
        } else {
            Minimax move = Minimax.getInstance();
            cond temp = move.getOptimalMove(fee, this.x, this.y);
            this.x = temp.x;  this.y = temp.y;
            fee[this.x][this.y] = step;
            step = 1;
            System.out.println("bot move: " + this.x + " " + this.y);
        }
    }

    public static PlayervsBot getInstance() {
        return new PlayervsBot();
    }

}
