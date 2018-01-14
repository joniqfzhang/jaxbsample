package xml.jaxb.thesaurus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//import test.model.NarrowItem;
import xml.jaxb.thesaurus.model.Thesaurus;
import xml.jaxb.thesaurus.model.ThesaurusRecord;
import xml.jaxb.thesaurus.service.ThesaurusService;
import xml.jaxb.thesaurus.service.ThesaurusServiceImp;

public class Application {

	public static void main(String[] args) throws ParseException, JAXBException, FileNotFoundException {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Thesaurus thesaurus0 = new Thesaurus(sdf.parse("01/12/2017"), sdf.parse("01/12/2018"), "name0" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus01 = new Thesaurus(sdf.parse("01/12/2017"), sdf.parse("01/12/2018"), "name01" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus10 = new Thesaurus(sdf.parse("10/12/2017"), sdf.parse("10/12/2018"), "name10" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus11 = new Thesaurus(sdf.parse("11/12/2017"), sdf.parse("11/12/2018"), "name11" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus20 = new Thesaurus(sdf.parse("20/12/2017"), sdf.parse("20/12/2018"), "name20" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus21 = new Thesaurus(sdf.parse("21/12/2017"), sdf.parse("21/12/2018"), "name21" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus22 = new Thesaurus(sdf.parse("22/12/2017"), sdf.parse("22/12/2018"), "name22" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus30 = new Thesaurus(sdf.parse("30/12/2017"), sdf.parse("30/12/2018"), "name30" , new ArrayList<Thesaurus>());
		Thesaurus thesaurus31 = new Thesaurus(sdf.parse("31/12/2017"), sdf.parse("31/12/2018"), "name31" , new ArrayList<Thesaurus>());
		
		thesaurus0.getThesaurusList().add(thesaurus10);
		thesaurus0.getThesaurusList().add(thesaurus11);
		
		thesaurus10.getThesaurusList().add(thesaurus20);
		thesaurus10.getThesaurusList().add(thesaurus21);
		
		thesaurus11.getThesaurusList().add(thesaurus20);
		thesaurus11.getThesaurusList().add(thesaurus21);
		thesaurus11.getThesaurusList().add(thesaurus22);
		
		thesaurus20.getThesaurusList().add(thesaurus30);
		thesaurus21.getThesaurusList().add(thesaurus31);
		
		ThesaurusService thesaurusService = new ThesaurusServiceImp();
		
		List<ThesaurusRecord> records= thesaurusService.createThesaurusRecords(thesaurus0);
		//need another a level0 record?
		//records.addAll(thesaurusService.createThesaurusRecords(thesaurus01));
		System.out.println(records.size());
		System.out.println(records.toString());
		
		JAXBContext jc = JAXBContext.newInstance(Thesaurus.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(thesaurus0, System.out);
	    marshaller.marshal(thesaurus0, new FileOutputStream("thesaurusW.xml"));
	    
	    Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("./thesaurusR.xml");
        Thesaurus  thesaurusR = (Thesaurus) unmarshaller.unmarshal(xml);
        List<ThesaurusRecord> recordsR= thesaurusService.createThesaurusRecords(thesaurusR);
        System.out.println(recordsR.size());
        System.out.println(recordsR.toString());
        System.out.println(records.toString());
	}

}
