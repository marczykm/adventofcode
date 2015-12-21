package day6;

/**
 * Created by marcin on 21.12.15.
 */
public class Light {

    private int brightness;

    public Light() {
        brightness = 0;
    }

    public int getBrightness() {
        return brightness;
    }

    public void turnUp(){
        brightness++;
    }

    public void turnDown() {
        brightness--;
        if (brightness < 0)
            brightness = 0;
    }
}
