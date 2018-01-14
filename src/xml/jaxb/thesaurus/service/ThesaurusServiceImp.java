package xml.jaxb.thesaurus.service;

import java.util.ArrayList;
import java.util.List;

import xml.jaxb.thesaurus.model.Thesaurus;
import xml.jaxb.thesaurus.model.ThesaurusRecord;

public class ThesaurusServiceImp implements ThesaurusService {
	@Override
	public List<ThesaurusRecord> createThesaurusRecords(Thesaurus root) {
		
		List<ThesaurusRecord> thesaurusRecords = new ArrayList<ThesaurusRecord>();
		if(root.getThesaurusList().size() > 0 ) {
			root.getThesaurusList().forEach( i1 -> {	
				if(i1.getThesaurusList().size() > 0) {
					i1.getThesaurusList().forEach(i2 ->{						
						if(i2.getThesaurusList().size() > 0) {
							// with level0, level1, level2, and level 3
							i2.getThesaurusList().forEach(i3 -> {								
								ThesaurusRecord thesaurusRecord = new ThesaurusRecord();
								thesaurusRecord.setLevel3(i3.getName());
								thesaurusRecord.setStartFrom(i3.getStartFrom());
								thesaurusRecord.setEndTo(i3.getEndTo());
								thesaurusRecord.setLevel2(i2.getName());
								thesaurusRecord.setLevel1(i1.getName());
								thesaurusRecord.setLevel0(root.getName());
								thesaurusRecords.add(thesaurusRecord);
							});
						}else{
							// with level0, level1, and level2
							ThesaurusRecord thesaurusRecord = new ThesaurusRecord();
							thesaurusRecord.setLevel2(i2.getName());
							thesaurusRecord.setLevel1(i1.getName());
							thesaurusRecord.setLevel0(root.getName());
							thesaurusRecord.setStartFrom(i2.getStartFrom());
							thesaurusRecord.setEndTo(i2.getEndTo());
							thesaurusRecords.add(thesaurusRecord);
						}						
					});
				}else{
					// with level0 and level1
					ThesaurusRecord thesaurusRecord = new ThesaurusRecord();
					thesaurusRecord.setLevel1(i1.getName());
					thesaurusRecord.setLevel0(root.getName());
					thesaurusRecord.setStartFrom(i1.getStartFrom());
					thesaurusRecord.setEndTo(i1.getEndTo());
					thesaurusRecords.add(thesaurusRecord);
				}					
			});			
		}else{
			// with level0
			ThesaurusRecord thesaurusRecord = new ThesaurusRecord();
			thesaurusRecord.setLevel0(root.getName());
			thesaurusRecord.setStartFrom(root.getStartFrom());
			thesaurusRecord.setEndTo(root.getEndTo());
			thesaurusRecords.add(thesaurusRecord);
		}
		// all records
		return thesaurusRecords;
	}

}
