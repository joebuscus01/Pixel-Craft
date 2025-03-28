import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Grayscale extends Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException { //throws exception if issue with input/output
    	
    	System.out.println("Converting to Grayscale. . .");
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
    	BufferedImage grayimage = new BufferedImage(originalImage.getWidth(),originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY); //blank gray image with original height & image
    	int rgb = 0, r = 0, g = 0, b = 0;
    	
    	//Think of image as pixels in rows & cols
    	for (int y = 0; y< originalImage.getHeight(); y++) { //each row
    		
    		for (int x = 0; x < originalImage.getWidth(); x++) { //width
    			// grab rgb
    			// seperate r, g, b
    			// add r, g, b & divide by 3
    			
    			rgb = originalImage.getRGB(x, y);
    			
    			ARGB col_seperate = new ARGB(rgb);
    			
    			rgb =   (col_seperate.red + col_seperate.blue + col_seperate.green) /3 ;
    			
    			rgb = 225 << 24 | rgb << 16 | rgb << 8 | rgb; 
    			grayimage.setRGB(x, y, rgb);
    			
    		
    			
    		}
    		
    	}
    	
    	File outputFile = new File(outputFileName);
    	ImageIO.write(grayimage, "PNG", outputFile); //output	
    	//  java -cp "C:\Users\joefe\Downloads\Pixel-Craft-main\Pixel-Craft-main" PixelCraft Grayscale "C:\Users\joefe\Downloads\Pixel-Craft-main\Pixel-Craft-main\toronto.png"
    }
    

}
