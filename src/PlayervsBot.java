import Core.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;


public class PlayervsBot extends PlayerVsPlayer {
    private void botThink() {
        Minimax move = Minimax.getInstance();
        cond temp = move.getOptimalMove(fee, this.x, this.y);
        this.x = temp.x;  this.y = temp.y;
        fee[this.x][this.y] = 2;
        System.out.println("bot move: " + this.x + " " + this.y);
    }
    public void actionGame() {

        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gamePlay.arrPosibleMove.size() != 0) {
                    getRowColumn(e.getX(), e.getY());

                    if (press(x, y) == true) {
                        System.out.println("step " + step);
                        gamePlay.flipChess(fee, step, x, y);
                        possibleMove = gamePlay.checkPosibleMove(fee, step);
                        System.out.println("Player move: " + x + " " + y);
                        computeBoard();
                        System.out.println("Score: " + p1Score + " " + p2Score);
                    }
                } else boardFrame.noMoves(step);

                if (gamePlay.checkEndGame(board) == true ) {
                    winner();
                }

                score = gamePlay.CountPlayerScore(board);
                p1Score = score.x;  p2Score = score.y;
                boardFrame.setBoard(stage, p1Score, p2Score, step);
                // step = 2;



                botThink();
                gamePlay.flipChess(fee, 1, x, y);
                possibleMove = gamePlay.checkPosibleMove(fee, 1);
                computeBoard();
                score = gamePlay.CountPlayerScore(board);
                p1Score = score.x;  p2Score = score.y;
                boardFrame.setBoard(stage, p1Score, p2Score, 1);
                step = 1;

            }
        });
    }
    public PlayervsBot() {
        super();
    }
    public static PlayervsBot getInstance() {
        return new PlayervsBot();
    }

}