/**
 * 
 */
package model;

/**
 * @author edwardtoday
 * 
 *         This is the container of a part object
 */
public class SinglePart {

	/**
	 * 
	 */
	public SinglePart() {
	}

	/**
	 * @param name
	 * @param code
	 * @param price
	 * 
	 *            Create a new part object with name, code and price given
	 */
	public SinglePart(final String name, final String code, final double price) {
		this.name = name;
		this.code = code;
		this.price = new Price(price);
		this.enabled = true;
	}

	/**
	 * @param name
	 * @param code
	 * @param price
	 */
	public SinglePart(final String name, final String code, final Price price) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.enabled = true;
	}

	/**
	 * @return part code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @return part name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return part notes
	 */
	public String getNotes() {
		return this.notes;
	}

	/**
	 * @return part price
	 */
	public Price getPrice() {
		return this.price;
	}

	/**
	 * @return whether part is enabled
	 */
	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * @param code
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * @param enabled
	 */
	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param notes
	 */
	public void setNotes(final String notes) {
		this.notes = notes;
	}

	/**
	 * @param price
	 */
	public void setPrice(final Price price) {
		this.price = price;
	}

	private String code;

	private boolean enabled;

	private String name;

	private String notes;

	private Price price;
}
