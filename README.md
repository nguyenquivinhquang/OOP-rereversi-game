﻿# OOP-rereversi-game
Menu:
  Trong menu sẽ có các method(function) cơ bản sau:
    
    + Display: ở đây sẽ xuất các jbuton, jframe etc
    
    + PlayervsPlayer: trong đây gọi PlayervsPlayer.getInstance();
    
    + PlayervsAi:  trong đây gọi PlayervsAi.getInstance();
    
    + Instruction: Trong đây sẽ hướng dẫn cách chơi
    + setPlayerName: nhập tên người chơi
    + choseBackground: người chơi sẽ chọn các hình nền bàn cờ, ( cái này thật ra là nếu player chọn hình nào thì mình sẽ đổi thông số Parameter.defaultBoard = địa chỉ của ảnh người đó chọn).
    + actionPerformed(ActionEvent e): e sẽ trả về cho biết người chơi đã ấn vào jbutton nào, rùi sẽ gọi các method theo jbutton đó.
    ....
    
    
 GUI:
 
    + display(int[][]): này sẽ nhận mảng gồm: 1: là nước của player1, 2 là player2, 3 là nước gợi ý, -1 là ô chưa đi; 
    
    + warning(int check): check = 1: in ra "This move already had, chose again: " , check = 2, in ra "This is not a valid move, chose again: "
    
    + getXY(int x, int y): hàm này trả về tọa độ x,y mà người dùng ấn
