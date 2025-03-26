import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class Grayscale extends Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException { //throws exception if issue with input/output
    	
    	System.out.println("Converting to Grayscale. . .");
    	File inputFile = new File("toronto.png");
    	System.out.println("inputFile" + inputFile);
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
    			r = ( (rgb >> 16 ) & 0xFF);
    			g = ( (rgb >> 8 ) & 0xFF);
    			b = ( rgb & 0xFF);
    			rgb = ( (int) r + g + b)/3;
    			rgb = 225 << 24 | rgb << 16 | rgb << 8 | rgb; 
    			grayimage.setRGB(x, y, rgb);
    			
    		
    			
    		}
    		
    	}
    	
    	
    	
    	if (originalImage != null) { //DELTE AT END
    		display(originalImage);
    	}
    	
    	
    	
    	File outputFile = new File(outputFileName);
    	// ImageIO.write(processedImage, "PNG", outputFile); //output	

    }
    
    //displays img using Swing 
    //DELETE WITH IMPORT IN FINAL COPY
    public static void display(BufferedImage img) {
    	System.out.println("Displayed Image: ");
    	//NOT MY CODE
    	JFrame frame = new JFrame();
	    JLabel label = new JLabel();
		frame.setSize(img.getWidth(), img.getHeight());
		label.setIcon(new ImageIcon(img));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// NOT MY CODE
    }

}
