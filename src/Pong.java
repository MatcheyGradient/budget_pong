import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.*;

public class Pong extends JPanel implements ActionListener {

    final static int height = 600;
    final static int width = 1000;
    final static int unit_size = 25;
    static double delay = 80 / Math.floor(PauseMenu.speedNum / 5f);
    static final int halfHeight = (int) Math.floor((height / unit_size) / 2f);
    static int pongX, pongY;
    double speedX = 1;
    double speedY = 1;
    boolean running = false;
    Timer timer = new Timer((int) delay, this);
    static int paddleSize = 7;
    static int[] firstPaddle = new int[paddleSize + 1];
    static int[] secondPaddle = new int[paddleSize + 1];
    static int pointPlayer2;
    static int pointPlayer1;
    static boolean paused = false;
    Menu menu;
    PauseMenu pMenu;
    HelpMenu hMenu;
    public static Mode mode = Mode.MENU;


    public Pong() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new keyListener());
        this.addMouseListener(new MouseListener());
        menu = new Menu();
        pMenu = new PauseMenu();
        hMenu = new HelpMenu();
        start();
    }

    public void start(){
        timer.start();
        pongX = 17;
        pongY = 12;
        running = true;
        createPaddles();
    }

    public void paint(Graphics g){
        super.paint(g);
        draw(g);
    }

    public void draw(Graphics g){

        if(mode == Mode.GAME){
            g.setColor(WHITE);
            for (int i = paddleSize; i > 0; i--){
                g.fillRect(unit_size, firstPaddle[i] * unit_size, unit_size, unit_size);

                g.fillRect(width - unit_size * 2, secondPaddle[i] * unit_size, unit_size, unit_size);
            }

            g.drawLine(width/2, 0, width/2, height);

            g.fillOval(pongX * unit_size, pongY * unit_size, unit_size, unit_size);

            g.setFont(new Font("arial", Font.PLAIN, 30));
            g.drawString(" " + pointPlayer2, width/2, 30);
            g.drawString("" + pointPlayer1, (width/2) - 50, 30);

            g.setColor(WHITE);
            for (int i = paddleSize; i > 0; i--){
                g.fillRect(unit_size, firstPaddle[i] * unit_size, unit_size, unit_size);
                g.fillRect(width - unit_size * 2, secondPaddle[i] * unit_size, unit_size, unit_size);
            }

            if(paused){
                pMenu.render(g);
            }
        }else if(mode == Mode.MENU){
            menu.render(g);
        }else if(mode == Mode.HELP){
            hMenu.render(g);
        }
    }

    public void movePong(){
        if(!paused){
            pongX += speedX;
            pongY += speedY;
        }
    }

    public void borderCollision(){
        if(pongX > (width/unit_size) - 2){
            pongX = 17;
            pongY = 12;
            pointPlayer1++;
        }
        if(pongY > (height/unit_size) - 2){
            speedY = -speedY;
        }
        if (pongX == 0){
            pongX = 17;
            pongY = 12;
            pointPlayer2++;
        }
        if (pongY == 0){
            speedY = -speedY;
        }
    }

    public static void resetGame() {
        delay = 80;
        pointPlayer1 = 0;
        pointPlayer2 = 0;
        pongX = 17;
        pongY = 12;
        PauseMenu.speedNum = 12;
        createPaddles();
    }

    public static void createPaddles(){
        for(int i = paddleSize; i > 0; i--){
            firstPaddle[i] = (int) (i + (halfHeight - (Math.ceil(paddleSize/2f))));
        }

        for(int i = paddleSize; i > 0; i--){
            secondPaddle[i] = (int) (i + (halfHeight - (Math.ceil(paddleSize/2f))));
        }
    }

    public void checkPaddleCollision(){
        for(int i = paddleSize; i > 0; i--){
            if(firstPaddle[i] == pongY && pongX == 2){
                speedX = -speedX;
            }
            if(secondPaddle[i] == pongY && pongX == (width/unit_size)-3){
                speedX = -speedX;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(mode == Mode.GAME){
            if(running){
                movePong();
                borderCollision();
                checkPaddleCollision();
                timer.setDelay((int) delay);
            }
            delay = 80 / Math.floor(PauseMenu.speedNum / 5f);
        }
        repaint();
    }

    public static class keyListener extends KeyAdapter {

        public void keyPressed(KeyEvent e){
            if(mode == Mode.GAME){
                    if(!paused){
                        switch(e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            if(secondPaddle[1] != 0){
                                for(int i = paddleSize; i > 0; i--){
                                    secondPaddle[i] -= 1;
                                }
                            }
                            break;

                        case KeyEvent.VK_DOWN:
                            if(secondPaddle[paddleSize] != (height/ unit_size) - 1){
                                for(int i = paddleSize; i > 0; i--){
                                    secondPaddle[i] += 1;
                                }
                            }
                            break;

                        case KeyEvent.VK_S:
                            if(firstPaddle[paddleSize] != (height/ unit_size) - 1){
                                for(int i = paddleSize; i > 0; i--){
                                    firstPaddle[i] += 1;
                                }
                            }
                            break;

                        case KeyEvent.VK_W:
                            if(firstPaddle[1] != 0){
                                for(int i = paddleSize; i > 0; i--){
                                    firstPaddle[i] -= 1;
                                }
                            }
                            break;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    paused = !paused;
                }
            }
        }
    }



    public enum Mode{
        GAME,
        MENU,
        HELP
    }
}
