/**
 * 
 */
package model;

/**
 * @author edwardtoday
 * 
 *         This class is used to store part objects that is an
 *         Application/Version choice.
 */
public class Application_Version extends SinglePart {

	/**
	 * @param app
	 * @param ver
	 * @param code
	 * @param price
	 */
	public Application_Version(final String app, final String ver,
			final String code, final double price) {
		super(app.toString() + Messages.getString("Application_Version.0") + ver.toString(), code, new Price(price)); //$NON-NLS-1$
		this.app = app;
		this.ver = ver;
	}

	/**
	 * @return application
	 */
	public String getApp() {
		return this.app;
	}

	/**
	 * @return version
	 */
	public String getVer() {
		return this.ver;
	}

	/**
	 * @param app
	 */
	public void setApp(final String app) {
		this.app = app;
	}

	/**
	 * @param ver
	 */
	public void setVer(final String ver) {
		this.ver = ver;
	}

	/**
	 * Apart from the fields of the super class, this class has two more
	 * specific fields to describe an object.
	 * 
	 * app for Application
	 * 
	 * ver for Version
	 */
	private String app;
	private String ver;
}
