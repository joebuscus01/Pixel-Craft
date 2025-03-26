import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Rotate extends Converter{
	public void convert(String inputFileName, String outputFileName) throws IOException {
		System.out.println("Rotating 90 degrees clockwise. . .");
    	File inputFile = new File("toronto.png");
    	System.out.println("inputFile" + inputFile);
    	BufferedImage originalImage = ImageIO.read(inputFile); //reads input
    	BufferedImage rotateimg = new BufferedImage(originalImage.getWidth(),originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB); //blank gray image with original height & image
    	int rgb = 0, r = 0, g = 0, b = 0;
    	
    	//Think of image as pixels in rows & cols
    	for (int y = 0; y< originalImage.getHeight(); y++) { //each row
    		
    		for (int x = 0; x < originalImage.getWidth(); x++) { //width
    			// grab rgb
    			// seperate r, g, b
    			// add r, g, b & divide by 3
    			
    			rgb = originalImage.getRGB(x, y);
    			
    			rotateimg.setRGB(y, x, rgb); // swaps x & y
    		}
    		
    	}
    	
    	
    	
    	if (originalImage != null) { //DELTE AT END 
    		display(originalImage);
    	}
    	
    	
    	
    	File outputFile = new File(outputFileName);
    	ImageIO.write(rotateimg, "PNG", outputFile); //output	

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

}
