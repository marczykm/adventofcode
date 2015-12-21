import day6.Grid;
import day6.Light;
import org.junit.*;

/**
 * Created by marcin on 17.12.15.
 */
public class Day6Test {

    @Test
    public void testLightInitOff() {
        Light light = new Light();
        Assert.assertEquals(0, light.getBrightness());
    }

    @Test
    public void testOn(){
        Light light = new Light();
        light.turnUp();
        Assert.assertEquals(1, light.getBrightness());
    }

    @Test
    public void testOnOff(){
        Light light = new Light();
        light.turnUp();
        light.turnDown();
        Assert.assertEquals(0, light.getBrightness());
    }

    @Test
    public void testOnOn(){
        Light light = new Light();
        light.turnUp();
        light.turnUp();
        Assert.assertEquals(2, light.getBrightness());
    }

    @Test
    public void testOffOff(){
        Light light = new Light();
        light.turnDown();
        light.turnDown();
        Assert.assertEquals(0, light.getBrightness());
    }

    @Test
    public void testGridInitAllOff() {
        Grid grid = new Grid();
        Assert.assertEquals(0, grid.getTotalBrightness());
    }

    @Test
    public void testGridOneLightOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,0,0);
        Assert.assertEquals(1, grid.getTotalBrightness());
    }

    @Test
    public void testGridAllLightsOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,999,999);
        Assert.assertEquals(1000*1000, grid.getTotalBrightness());
    }

    @Test
    public void testGridNineLightOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,2,2);
        Assert.assertEquals(9, grid.getTotalBrightness());
    }

    @Test
    public void testGridOneLightOnOn() {
        Grid grid = new Grid();
        grid.turnOn(0,0,2,2);
        grid.turnOn(0,0,2,2);
        Assert.assertEquals(18, grid.getTotalBrightness());
    }

    @Test
    public void testParseOn() {
        Grid grid = new Grid();
        grid.parse("turn on 0,0 through 2,2");
        Assert.assertEquals(9, grid.getTotalBrightness());
    }

    @Test
    public void testParseOff() {
        Grid grid = new Grid();
        grid.parse("turn on 0,0 through 2,2");
        grid.parse("turn off 0,0 through 2,2");
        Assert.assertEquals(0, grid.getTotalBrightness());
    }

    @Test
    public void testParseToggle() {
        Grid grid = new Grid();
        grid.parse("toggle 0,0 through 2,2");
        Assert.assertEquals(18, grid.getTotalBrightness());
    }
}
