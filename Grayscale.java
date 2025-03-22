import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class Grayscale extends Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException { //throws exception if issue with input/output
    	File inputFile = new File("toronto.png");
    	System.out.println("inputFile" + inputFile);
    	BufferedImage originalImage = ImageIO.read(inputFile); //reads input
    	
    	if (originalImage != null) {
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
