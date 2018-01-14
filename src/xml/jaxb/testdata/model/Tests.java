package xml.jaxb.testdata.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tests {
	TestData testData;
	@XmlElement(name="test-data")
	public TestData getTestData() {
		return testData;
	}

	public void setTestData(TestData testData) {
		this.testData = testData;
	}

}
