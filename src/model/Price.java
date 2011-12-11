/**
 * 
 */
package model;

/**
 * @author edwardtoday
 * 
 *         This is used to store the price of whatever necessary. Prices are not
 *         considered is this demo.
 */
public class Price {

	/**
	 * 
	 */
	public Price() {
		this.price = 0;
		this.discount = 1;
	}

	/**
	 * @param price
	 */
	public Price(final double price) {
		super();
		if (price >= 0) {
			this.price = price;
		} else {
			this.price = 0;
			System.out.println(this.price_err);
		}
	}

	/**
	 * @param price
	 * @param discount
	 */
	public Price(final double price, final double discount) {
		super();
		if (price >= 0) {
			this.price = price;
		} else {
			this.price = 0;
			System.out.println(this.price_err);
		}
		if ((discount <= 1) && (discount >= 0)) {
			this.discount = discount;
		} else {
			this.discount = 1;
			System.out.println(this.discount_err);
		}
	}

	/**
	 * @return discount
	 */
	public double getDiscount() {
		return this.discount;
	}

	/**
	 * @return price after discount
	 */
	public double getPrice() {
		return this.price * this.discount;
	}

	/**
	 * @param discount
	 */
	public void setDiscount(final double discount) {
		if ((discount <= 1) && (discount >= 0)) {
			this.discount = discount;
		} else {
			this.discount = 1;
			System.out.println(this.discount_err);
		}
	}

	/**
	 * @param price
	 */
	public void setPrice(final double price) {
		if (price >= 0) {
			this.price = price;
		} else {
			this.price = 0;
			System.out.println(this.price_err);
		}
	}

	private final String discount_err = Messages.getString("Price.0"); //$NON-NLS-1$

	private final String price_err = Messages.getString("Price.1"); //$NON-NLS-1$

	double discount;

	double price;
}
