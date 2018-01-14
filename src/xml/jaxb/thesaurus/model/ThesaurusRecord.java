package xml.jaxb.thesaurus.model;

import java.util.Date;

public class ThesaurusRecord {
	private Date startFrom;
	private Date endTo;
	private String level0;
	private String level1;
	private String level2;
	private String level3;
	/**
	 * @return the startFrom
	 */
	public Date getStartFrom() {
		return startFrom;
	}
	/**
	 * @param startFrom the startFrom to set
	 */
	public void setStartFrom(Date startFrom) {
		this.startFrom = startFrom;
	}
	/**
	 * @return the endTo
	 */
	public Date getEndTo() {
		return endTo;
	}
	/**
	 * @param endTo the endTo to set
	 */
	public void setEndTo(Date endTo) {
		this.endTo = endTo;
	}
	/**
	 * @return the level0
	 */
	public String getLevel0() {
		return level0;
	}
	/**
	 * @param level0 the level0 to set
	 */
	public void setLevel0(String level0) {
		this.level0 = level0;
	}
	/**
	 * @return the level1
	 */
	public String getLevel1() {
		return level1;
	}
	/**
	 * @param level1 the level1 to set
	 */
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	/**
	 * @return the level2
	 */
	public String getLevel2() {
		return level2;
	}
	/**
	 * @param level2 the level2 to set
	 */
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	/**
	 * @return the level3
	 */
	public String getLevel3() {
		return level3;
	}
	/**
	 * @param level3 the level3 to set
	 */
	public void setLevel3(String level3) {
		this.level3 = level3;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ThesaurusRecord [startFrom=" + startFrom + ", endTo=" + endTo + ", level0=" + level0 + ", level1="
				+ level1 + ", level2=" + level2 + ", level3=" + level3 + "]";
	}
	
	
	
	
}
