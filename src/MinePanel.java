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

public class MinePanel extends JPanel implements ActionListener {
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

    int pickaxe_value;

    int blockX;
    int blockY;

    int blockX_1;
    int blockY_1;

    int blockX_2;
    int blockY_2;

    int blockX_3;
    int blockY_3;

    int blockX_4;
    int blockY_4;

    int blockX_5;
    int blockY_5;

    int blockX_6;
    int blockY_6;

    int blockX_7;
    int blockY_7;

    int blockX_8;
    int blockY_8;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    MinePanel(){
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new MinePanel.MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newBlock();
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

            g.drawImage(new ImageIcon("DATA/textures/pickaxe.png").getImage(),
                    appleX, appleY, null);

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
            if (Objects.equals(Bank.selectPack, "Standard")) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX, blockY, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_1, blockY_1, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_2, blockY_2, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_3, blockY_3, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_4, blockY_4, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_5, blockY_5, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_6, blockY_6, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_7, blockY_7, UNIT_SIZE, UNIT_SIZE);

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(blockX_8, blockY_8, UNIT_SIZE, UNIT_SIZE);
            }
            else if (Objects.equals(Bank.selectPack, "Portal")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX, blockY, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_1, blockY_1, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_2, blockY_2, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_3, blockY_3, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_4, blockY_4, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_5, blockY_5, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_6, blockY_6, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_7, blockY_7, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Portal/block.png").getImage(),
                        blockX_8, blockY_8, null);
            }
            else if (Objects.equals(Bank.selectPack, "Mine")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX, blockY, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_1, blockY_1, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_2, blockY_2, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_3, blockY_3, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_4, blockY_4, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_5, blockY_5, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_6, blockY_6, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_7, blockY_7, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Minecraft/block.png").getImage(),
                        blockX_8, blockY_8, null);
            }
            else if (Objects.equals(Bank.selectPack, "Simp")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX, blockY, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_1, blockY_1, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_2, blockY_2, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_3, blockY_3, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_4, blockY_4, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_5, blockY_5, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_6, blockY_6, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_7, blockY_7, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Simpsons/block.png").getImage(),
                        blockX_8, blockY_8, null);
            }
            else if (Objects.equals(Bank.selectPack, "Sonic")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX, blockY, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_1, blockY_1, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_2, blockY_2, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_3, blockY_3, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_4, blockY_4, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_5, blockY_5, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_6, blockY_6, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_7, blockY_7, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/Sonic/block.png").getImage(),
                        blockX_8, blockY_8, null);
            }
            else if (Objects.equals(Bank.selectPack, "Rick")) {
                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX, blockY, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_1, blockY_1, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_2, blockY_2, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_3, blockY_3, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_4, blockY_4, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_5, blockY_5, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_6, blockY_6, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_7, blockY_7, null);

                g.drawImage(new ImageIcon("DATA/textures/skinPacks/RickAndMorty/block.png").getImage(),
                        blockX_8, blockY_8, null);
            }


            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten + " Pickaxe: " + pickaxe_value,
                    (SCREEN_WIDTH -
                            metrics.stringWidth("Score: " + applesEaten + " Pickaxe: " + pickaxe_value))/2,
                    g.getFont().getSize());
        }else {
            gameOver(g);
        }
    }

    public void newApple(){
        appleX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        newBlock();
    }

    public void newBlock(){
        blockX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_1 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_1 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_2 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_2 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_3 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_3 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_4 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_4 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_5 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_5 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_6 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_6 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_7 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_7 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

        blockX_8 = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        blockY_8 = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
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
            pickaxe_value++;
            newApple();
        }
        else if ((x[0] == blockX) && (y[0] == blockY) && pickaxe_value >= 1 || (x[0] == blockX_1) && (y[0] == blockY_1) && pickaxe_value >= 1 ||
                (x[0] == blockX_2) && (y[0] == blockY_2) && pickaxe_value >= 1 ||
                (x[0] == blockX_3) && (y[0] == blockY_3) && pickaxe_value >= 1 ||
                (x[0] == blockX_4) && (y[0] == blockY_4) && pickaxe_value >= 1 ||
                (x[0] == blockX_5) && (y[0] == blockY_5) && pickaxe_value >= 1 ||
                (x[0] == blockX_6) && (y[0] == blockY_6) && pickaxe_value >= 1 ||
                (x[0] == blockX_7) && (y[0] == blockY_7) && pickaxe_value >= 1 ||
                (x[0] == blockX_8) && (y[0] == blockY_8) && pickaxe_value >= 1) {
            applesEaten++;
            pickaxe_value--;
            newApple();
        }
        else if ((x[0] == blockX) && (y[0] == blockY) || (x[0] == blockX_1) && (y[0] == blockY_1) ||
                (x[0] == blockX_2) && (y[0] == blockY_2) ||
                (x[0] == blockX_3) && (y[0] == blockY_3) ||
                (x[0] == blockX_4) && (y[0] == blockY_4) ||
                (x[0] == blockX_5) && (y[0] == blockY_5) ||
                (x[0] == blockX_6) && (y[0] == blockY_6) ||
                (x[0] == blockX_7) && (y[0] == blockY_7) ||
                (x[0] == blockX_8) && (y[0] == blockY_8) & pickaxe_value == 0) {
            running = false;
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
