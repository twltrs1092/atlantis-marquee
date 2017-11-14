package gui;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import static util.Global.OFF_COLOR;

public class LED extends Circle
{
    private boolean on;
    private Paint paint;
    private boolean background;

    public LED(int radius)
    {
        this(radius, false);
    }

    public LED(int radius, boolean background)
    {
        super(radius, OFF_COLOR);

        if (!background)
        {
            super.setOpacity(0);
        }

        on = false;
    }

    public boolean isOn()
    {
        return on;
    }

    public void turnOn(Color color, int intensity)
    {
        paint = color;
        turnOn();
    }

    public void turnOn(Paint paint)
    {
        this.paint = paint;
        this.setOpacity(1);
        turnOn();
    }

    public void turnOn()
    {
        this.setFill(paint);
        on = true;
    }

    public void turnOff()
    {
        this.setFill(OFF_COLOR);

        if (!background)
        {
            super.setOpacity(0);
        }

        on = false;
    }
}
