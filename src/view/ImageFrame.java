/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author edwardtoday
 * 
 *         A frame to show image
 */
public class ImageFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8971434490887427729L;

	/**
	 * 
	 */
	public static final int SCREEN_HEIGHT = ImageFrame.screenSize.height;

	/**
	 * 
	 */
	public static final int SCREEN_WIDTH = ImageFrame.screenSize.width;
	private static Toolkit kit = Toolkit.getDefaultToolkit();
	/**
	 * Get screen sizes
	 */
	private static Dimension screenSize = ImageFrame.kit.getScreenSize();

	/**
	 * @param filename
	 */
	public ImageFrame(final String filename) {
		this.setTitle(Messages.getString("ImageFrame.0")); //$NON-NLS-1$
		this.setSize(ImageFrame.SCREEN_WIDTH, ImageFrame.SCREEN_HEIGHT);

		// add component to frame
		final ImageComponent component = new ImageComponent();
		component.SetImage(filename);
		component.setResizeToFit(true);
		// component.setResizeToFit(true);
		this.add(component);
	}
}

class ImageComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8642625956577110779L;

	public ImageComponent() {
	}

	public String getImgFilename() {
		return this.imgFilename;
	}

	@Override
	public void paintComponent(final Graphics g) {
		if (this.image == null)
			return;

		// zoom the image to fit canvas
		int imageWidth = this.image.getWidth(this);
		int imageHeight = this.image.getHeight(this);
		if (this.resizeToFit) {
			final int canvasWidth = super.getWidth();
			final int canvasHeight = super.getHeight();
			if (((imageWidth < canvasWidth) && (imageHeight > canvasHeight))
					|| ((imageWidth > canvasWidth)
							&& (imageHeight > canvasHeight) && (imageWidth
							* canvasHeight < imageHeight * canvasWidth))) {
				imageWidth = imageWidth * canvasHeight / imageHeight;
				imageHeight = canvasHeight;
			} else if (((imageWidth > canvasWidth) && (imageHeight < canvasHeight))
					|| ((imageWidth > canvasWidth)
							&& (imageHeight > canvasHeight) && (imageWidth
							* canvasHeight > imageHeight * canvasWidth))) {
				imageHeight = imageHeight * canvasWidth / imageWidth;
				imageWidth = canvasWidth;
			}
		}
		// draw the image in the top-left corner
		g.drawImage(this.image, 0, 0, imageWidth, imageHeight, null);
	}

	public void SetImage(final String filename) {
		// acquire the image
		try {
			// URL aboutURL = getClass().getResource("about.gif");
			// Image img = Toolkit.getDefaultToolkit().getImage(aboutURL);
			// URL imgURL = getClass().getResource(filename);
			final File imgFile = new File(filename);
			if (imgFile.exists()) {
				// if (!imgURL.getFile().equals("")) {
				this.setImgFilename(filename);
				// image = Toolkit.getDefaultToolkit().getImage(imgURL);
				this.image = ImageIO.read(new File(filename));
			} else {
				this.setImgFilename(null);
				this.image = null;
			}
		} catch (final Exception e) {
			// e.printStackTrace();
		}
		this.repaint();
	}

	public void setResizeToFit(final boolean resizeToFit) {
		this.resizeToFit = resizeToFit;
		this.repaint();
	}

	private void setImgFilename(final String imgFilename) {
		this.imgFilename = imgFilename;
	}

	private Image image;
	private String imgFilename;

	private boolean resizeToFit = true;
}