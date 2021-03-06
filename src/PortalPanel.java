import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Random;

public class PortalPanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;

    int portalA_X;
    int portalA_Y;

    int portalB_X;
    int portalB_Y;

    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    PortalPanel(){
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new PortalPanel.MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if (running) {
            if(Objects.equals(Bank.selectPack, "Sonic")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/arena.png").getImage(),
                        0, 0, null);
            }
            else if (Objects.equals(Bank.selectPack, "Simp")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/arena.png").getImage(),
                        0, 0, null);
            }
            else if (Objects.equals(Bank.selectPack, "Mine")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/arena.png").getImage(),
                        0, 0, null);
            }

            if (Objects.equals(Bank.selectPack, "Standard")) {
                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else if (Objects.equals(Bank.selectPack, "Portal")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/apple.png").getImage(),
                        appleX, appleY, null);
            }
            else if (Objects.equals(Bank.selectPack, "Mine")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/apple.png").getImage(),
                        appleX, appleY, null);
            }
            else if (Objects.equals(Bank.selectPack, "Simp")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/apple.png").getImage(),
                        appleX, appleY, null);
            }
            else if (Objects.equals(Bank.selectPack, "Sonic")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/apple.png").getImage(),
                        appleX, appleY, null);
            }
            else if (Objects.equals(Bank.selectPack, "Rick")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/apple.png").getImage(),
                        appleX, appleY, null);
            }

            if (Objects.equals(Bank.selectPack, "Portal")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/portalA.png").getImage(),
                        portalA_X, portalA_Y, null);
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/portalB.png").getImage(),
                        portalB_X, portalB_Y, null);
            }
            else if (Objects.equals(Bank.selectPack, "Rick")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/portal.png").getImage(),
                        portalA_X, portalA_Y, null);
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/portal.png").getImage(),
                        portalB_X, portalB_Y, null);
            }
            else{
                g.setColor(Color.blue);
                g.fillOval(portalA_X, portalA_Y, 30, 30);

                g.setColor(Color.orange);
                g.fillOval(portalB_X, portalB_Y, 30, 30);
            }

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    if (Objects.equals(Bank.selectPack, "Standard")) {
                        g.setColor(Color.green);
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else if (Objects.equals(Bank.selectPack, "Portal")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/head.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Mine")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/head.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Simp")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/head.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Sonic")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/head.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Rick")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/head.png").getImage(),
                                x[i], y[i], null);
                    }
                } else {
                    if (Objects.equals(Bank.selectPack, "Standard")) {
                        g.setColor(new Color(45, 180, 0));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else if (Objects.equals(Bank.selectPack, "Portal")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/body.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Mine")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/body.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Simp")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/body.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Sonic")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/body.png").getImage(),
                                x[i], y[i], null);
                    }
                    else if (Objects.equals(Bank.selectPack, "Rick")) {
                        g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/body.png").getImage(),
                                x[i], y[i], null);
                    }
                }
            }


            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten,
                    (SCREEN_WIDTH -
                            metrics.stringWidth("Score: " + applesEaten))/2,
                    g.getFont().getSize());
        }else {
            gameOver(g);
        }
    }

    public void newApple(){
        appleX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        newSuperApple();
    }

    public void newSuperApple(){
        portalA_X = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        portalA_Y = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        portalB_X = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        portalB_Y = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }

    public void move(){
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    public void checkApple(){
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        } else if ((x[0] == portalA_X) && (y[0] == portalA_Y)) {
            x[0] = portalB_X;
            y[0] = portalB_Y;
        } else if ((x[0] == portalB_X) && (y[0] == portalB_Y)) {
            x[0] = portalA_X;
            y[0] = portalA_Y;
        }
    }

    public void checkCollisions(){
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }

        if(x[0] < 0){
            running = false;
        }

        if(x[0] >= SCREEN_WIDTH){
            running = false;
        }

        if(y[0] < 0){
            running = false;
        }

        if(y[0] >= SCREEN_HEIGHT){
            running = false;
        }

        if(!running){
            timer.stop();
        }

    }

    public void saveData(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("DATA/saves/save.txt"));
            bw.write(Integer.toString(Bank.money + applesEaten));
            bw.write("\n" + Bank.portalPack);
            bw.write("\n" + Bank.rickPack);
            bw.write("\n" + Bank.minePack);
            bw.write("\n" + Bank.simpPack);
            bw.write("\n" + Bank.sonicPack);
            bw.close();
        }catch (Exception ignored){}
    }

    public void gameOver(Graphics g){
        saveData();
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten,
                (SCREEN_WIDTH -
                        metrics1.stringWidth("Score: " + applesEaten))/2,
                g.getFont().getSize());

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",
                (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,
                SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
