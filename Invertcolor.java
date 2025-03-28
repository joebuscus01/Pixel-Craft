
	import javax.imageio.ImageIO;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
public class Invertcolor extends Converter{

	    public void convert(String inputFileName, String outputFileName) throws IOException { //throws exception if issue with input/output
	    	
	    	System.out.println("Inverting colors. . .");
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
	    	BufferedImage invertimage = new BufferedImage(originalImage.getWidth(),originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB); //blank gray image with original height & image
	    	int rgb = 0, r = 0, g = 0, b = 0;
	    	
	    	//Think of image as pixels in rows & cols
	    	for (int y = 0; y< originalImage.getHeight(); y++) { //each row
	    		
	    		for (int x = 0; x < originalImage.getWidth(); x++) { //width
	    			// grab rgb
	    			// seperate r, g, b
	    			// add r, g, b & divide by 3
	    			
	    			rgb = originalImage.getRGB(x, y);
	    			ARGB invert = new ARGB(rgb);
	    			
	    			invert.red = 255 - invert.red;
	    			invert.green = 255 - invert.green;
	    			invert.blue = 255 - invert.blue;
	    			
	    			
	    				    			
	    			invertimage.setRGB(x, y, invert.toInt());
	    			
	    		
	    			
	    		}
	    		
	    	}
	    	
	    	File outputFile = new File(outputFileName);
	    	ImageIO.write(invertimage, "PNG", outputFile); //output	
	    }
}
	    
