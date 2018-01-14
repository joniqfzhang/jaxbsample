package xml.jaxb.thesaurus.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(namespace="xml.jaxb.thesaurus.model")
public class Thesaurus {
	private Date startFrom;
	private Date endTo;
	private String name;
	private List<Thesaurus> thesaurusList;
	
	public Thesaurus() {
		super();
	}
	
	public Thesaurus(Date startFrom, Date endTo, String name, List<Thesaurus> thesaurusList) {
		super();
		this.startFrom = startFrom;
		this.endTo = endTo;
		this.name = name;
		this.thesaurusList = thesaurusList;
	}
	public Date getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(Date startFrom) {
		this.startFrom = startFrom;
	}
	public Date getEndTo() {
		return endTo;
	}
	public void setEndTo(Date endTo) {
		this.endTo = endTo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// XmlElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name="narrowItem")
	// XmlElement sets the name of the entities
	@XmlElement(name="thesaurus")
	public List<Thesaurus> getThesaurusList() {
		return thesaurusList;
	}
	public void setThesaurusList(List<Thesaurus> thesaurusList) {
		this.thesaurusList = thesaurusList;
	}
	
}
