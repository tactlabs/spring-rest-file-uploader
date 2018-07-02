package org.tact.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextWriterTamil {

	public static void main(String arg[]) throws IOException, FontFormatException {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("c:/test/Lohit-Tamil.ttf")));
		
		Font localFont = Font.createFont(Font.TRUETYPE_FONT, new File("c:/test/Lohit-Tamil.ttf"));
		localFont.getFontName();		
		System.out.println(localFont.getFontName());
		
        String key = "தியாகராஜர் பொறியியற்கல்லூரி ";
        
        BufferedImage bufferedImage = ImageIO.read(new File("c:/test/tce.jpg"));
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Lohit Tamil", Font.BOLD, 50));
        graphics.drawString(key, 50, 500);
        ImageIO.write(bufferedImage, "jpg", new File("C:/test/springboot2.jpg"));
        System.out.println("Image Created");
    }
}
