package day6;

/**
 * Created by marcin on 21.12.15.
 */
public class Light {
    private LightStatus status;

    public Light() {
        this.status = LightStatus.OFF;
    }

    public LightStatus getStatus() {
        return status;
    }

    public void on(){
        this.status = LightStatus.ON;
    }

    public void off() {
        this.status = LightStatus.OFF;
    }

    public void toggle() {
        if (this.status == LightStatus.ON)
            this.status = LightStatus.OFF;
        else
            this.status = LightStatus.ON;
    }
}
