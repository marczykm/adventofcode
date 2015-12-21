package day6;

/**
 * Created by marcin on 21.12.15.
 */
public class Grid {
    private final int WIDTH = 999;
    private final int HEIGHT = 999;

    private Light[][] lights;

    public Grid() {
        lights = new Light[WIDTH+1][HEIGHT+1];

        for (int i = 0; i <= WIDTH; i++)
            for (int j = 0; j <= HEIGHT; j++)
                lights[i][j] = new Light();
    }

    public void turnOn(int startX, int startY, int endX, int endY){
        for (int i = startX; i <= endX; i++)
            for (int j = startY; j <= endY; j++)
                lights[i][j].on();
    }

    public void turnOff(int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endX; i++)
            for (int j = startY; j <= endY; j++)
                lights[i][j].off();
    }

    public void toggle(int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endX; i++)
            for (int j = startY; j <= endY; j++)
                lights[i][j].toggle();
    }

    public int countLitLights(){
        int lit = 0;

        for (int i = 0; i <= WIDTH; i++)
            for (int j = 0; j <= HEIGHT; j++)
                if (lights[i][j].getStatus() == LightStatus.ON)
                    lit++;
        return lit;
    }

    public void parse(String line) {
        Algorithm a = null;
        if (line.startsWith("turn on")){
            a = Algorithm.ON;
            line = line.replace("turn on ", "");
        } else if (line.startsWith("turn off")){
            a = Algorithm.OFF;
            line = line.replace("turn off ", "");
        } else if (line.startsWith("toggle")){
            a = Algorithm.TOGGLE;
            line = line.replace("toggle ", "");
        }
        line = line.replace("through ", "");
        String[] splittedBySpace = line.split(" ");
        String[] xy1 = splittedBySpace[0].split(",");
        String[] xy2 = splittedBySpace[1].split(",");
        int startX = Integer.parseInt(xy1[0]);
        int startY = Integer.parseInt(xy1[1]);
        int endX = Integer.parseInt(xy2[0]);
        int endY = Integer.parseInt(xy2[1]);

        switch (a){
            case ON:
                turnOn(startX, startY, endX, endY);
                break;
            case OFF:
                turnOff(startX, startY, endX, endY);
                break;
            case TOGGLE:
                toggle(startX, startY, endX, endY);
                break;
        }
    }

    enum Algorithm {
        ON,
        OFF,
        TOGGLE
    }
}
