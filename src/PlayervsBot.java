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
            cond temp = move.getOptimalMove(board, this.x, this.y);
            step = 1;
        }
    }

    public static PlayervsBot getInstance() {
        return new PlayervsBot();
    }

}
