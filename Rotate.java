import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Rotate extends Converter{
	public void convert(String inputFileName, String outputFileName) throws IOException { // 
		System.out.println("Rotating 90 degrees clockwise. . .");
    	File inputFile = new File(inputFileName);
    	
    	System.out.println("inputFile " + inputFile.getAbsolutePath());
    	
    	if (!inputFile.exists()) {
            System.out.println("Error: File does not exist!");
            return;
        }
        if (!inputFile.canRead()) {
            System.out.println("Error: File cannot be read!");
            return;
        }
    	BufferedImage originalImage = ImageIO.read(inputFile); //reads input
    	BufferedImage rotateimg = new BufferedImage(originalImage.getHeight(),originalImage.getWidth(), BufferedImage.TYPE_INT_ARGB); //blank gray image with original height & image
    	int rgb = 0, r = 0, g = 0, b = 0;
    	
    	//Think of image as pixels in rows & cols
    	for (int y = 0; y< originalImage.getHeight(); y++) { //each row
    		
    		for (int x = 0; x < originalImage.getWidth(); x++) { //width
    			// grab rgb
    			// seperate r, g, b
    			// add r, g, b & divide by 3
    			
    			rgb = originalImage.getRGB(x,y);
    			
    			rotateimg.setRGB( originalImage.getHeight() - 1 - y, x, rgb); // DONE
    		}
    		
    	}
    	
    	File outputFile = new File(outputFileName);
    	ImageIO.write(rotateimg, "PNG", outputFile); //output	

    }
    
  


}
