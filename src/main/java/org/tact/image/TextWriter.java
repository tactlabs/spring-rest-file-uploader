package org.tact.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextWriter {

	public static void main(String arg[]) throws IOException {
        
		String key = "Sample";
        
        BufferedImage bufferedImage = ImageIO.read(new File("c:/test/tce.jpg"));
        
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
        graphics.drawString(key, 10, 25);

        ImageIO.write(bufferedImage, "jpg", new File("C:/test/springboot1.jpg"));
        System.out.println("Image Created");
    }
}
