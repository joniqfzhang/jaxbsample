package xml.stax;

public class Item {
	private String date;
    private String mode;
    private String unit;
    private String current;
    private String interactive;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the current
	 */
	public String getCurrent() {
		return current;
	}
	/**
	 * @param current the current to set
	 */
	public void setCurrent(String current) {
		this.current = current;
	}
	/**
	 * @return the interactive
	 */
	public String getInteractive() {
		return interactive;
	}
	/**
	 * @param interactive the interactive to set
	 */
	public void setInteractive(String interactive) {
		this.interactive = interactive;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [date=" + date + ", mode=" + mode + ", unit=" + unit + ", current=" + current + ", interactive="
				+ interactive + "]";
	}
    
}
