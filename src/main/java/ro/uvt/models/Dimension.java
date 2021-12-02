package ro.uvt.models;

public class Dimension{
    private int height;
    private int width;

    public Dimension(int height, int width) {
        this.height = height;
        this.width = width;
    }
    

    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }


    public void println() {
        System.out.println("H: " + height + " W: " + width);
    }
}