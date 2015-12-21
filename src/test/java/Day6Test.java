import day6.Day6;
import day6.Grid;
import day6.Light;
import day6.LightStatus;
import org.junit.*;

/**
 * Created by marcin on 17.12.15.
 */
public class Day6Test {

    @Test
    public void testLightInitOff() {
        Light light = new Light();
        Assert.assertEquals(LightStatus.OFF, light.getStatus());
    }

    @Test
    public void testOffOn(){
        Light light = new Light();
        light.on();
        Assert.assertEquals(LightStatus.ON, light.getStatus());
    }

    @Test
    public void testOnOff(){
        Light light = new Light();
        light.on();
        light.off();
        Assert.assertEquals(LightStatus.OFF, light.getStatus());
    }

    @Test
    public void testOnOn(){
        Light light = new Light();
        light.on();
        light.on();
        Assert.assertEquals(LightStatus.ON, light.getStatus());
    }

    @Test
    public void testToggle(){
        Light light = new Light();
        light.toggle();
        Assert.assertEquals(LightStatus.ON, light.getStatus());
    }

    @Test
    public void testGridInitAllOff() {
        Grid grid = new Grid();
        Assert.assertEquals(0, grid.countLitLights());
    }

    @Test
    public void testGridOneLightOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,0,0);
        Assert.assertEquals(1, grid.countLitLights());
    }

    @Test
    public void testGridAllLightsOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,999,999);
        Assert.assertEquals(1000*1000, grid.countLitLights());
    }

    @Test
    public void testGridNineLightOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,2,2);
        Assert.assertEquals(9, grid.countLitLights());
    }
}
