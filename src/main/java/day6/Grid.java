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
}
