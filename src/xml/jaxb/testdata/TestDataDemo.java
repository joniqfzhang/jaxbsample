package xml.jaxb.testdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import xml.jaxb.testdata.model.Tests;

public class TestDataDemo {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(Tests.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("./input.xml");
        Tests tests = (Tests) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tests, System.out);
        marshaller.marshal(tests,new FileOutputStream("testdata-output.xml"));

	}

}
