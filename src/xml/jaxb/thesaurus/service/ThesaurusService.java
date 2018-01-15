package xml.jaxb.thesaurus.service;

import java.util.List;

import xml.jaxb.thesaurus.model.Thesaurus;
import xml.jaxb.thesaurus.model.ThesaurusRecord;

public interface ThesaurusService {
	public List<ThesaurusRecord> createThesaurusRecords(Thesaurus root);
	public void createThesaurusInserts(List<ThesaurusRecord> thesaurusRecordList, String fileName);
}
