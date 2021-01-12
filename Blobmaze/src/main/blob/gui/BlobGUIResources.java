package main.blob.gui;



import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

public class BlobGUIResources {
	
	public static final BufferedImage IMG_SOIL;
	public static final BufferedImage IMG_GOAL;
    public static final BufferedImage IMG_STONES[];
    
	public static final URL load(final String resource) throws URISyntaxException {
    	final URL url = (
    		ClassLoader.getSystemClassLoader().getResource(resource)
    	);
    	return url;
    }
    
	static {
		try {
			//
		    IMG_SOIL = ImageIO.read(load("main/blob/resources/soil.png"));
		    IMG_STONES = new BufferedImage[]{
		        ImageIO.read(load("main/blob/resources/stone1.png")),
                ImageIO.read(load("main/blob/resources/stone2.png"))
		    };
		    IMG_GOAL = ImageIO.read(load("main/blob/resources/goal.png"));
            //
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}