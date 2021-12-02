package ro.uvt.services;

public class BMPImageLoader implements ImageLoader{

    private final String imageName;

    public BMPImageLoader(String imageName)
    {
        this.imageName = imageName;
    }
    public void loadImage(String str) {
        // TODO Auto-generated method stub
        System.out.println("Loaded image: " + str);
    }
    
}
