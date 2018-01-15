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
	
	@Override
	public void createThesaurustermInserts(List<ThesaurusRecord> thesaurustermRecordList, String fileToWrite) {
		Path sqlInsertFile = Paths.get(fileToWrite);
		//https://stackoverflow.com/questions/19794101/how-to-overwrite-file-via-java-nio-writer for file output content control
		try (BufferedWriter writer = 
                Files.newBufferedWriter(sqlInsertFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
			thesaurustermRecordList.forEach(r -> {
				try {
					writer.write(insertThesaurustermSql(r));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
          
       } catch (Exception e) {
           e.printStackTrace();
       }

	}
	
	private List<ThesaurusRecord> sortThesaurustermRecords(List<ThesaurusRecord> thesaurustermRecords) {
		Comparator<ThesaurustermRecord> sortByLevel0 = (t1, t2) -> t1.getLevel0().compareToIgnoreCase(t2.getLevel0());
		Comparator<ThesaurustermRecord> sortByLevel1 = (t1, t2) -> t1.getLevel1().compareToIgnoreCase(t2.getLevel1());
		Comparator<ThesaurustermRecord> sortByLevel2 = (t1, t2) -> t1.getLevel2().compareToIgnoreCase(t2.getLevel2());
		Comparator<ThesaurustermRecord> sortByLevel3 = (t1, t2) -> t1.getLevel3().compareToIgnoreCase(t2.getLevel3());

		List<ThesaurustermRecord> sortedThesaurustermRecords = thesaurustermRecords
				.stream()
				.sorted(sortByLevel0
						.thenComparing(sortByLevel1)
						.thenComparing(sortByLevel2)
						.thenComparing(sortByLevel3))
				.collect(Collectors.toList());
		return sortedThesaurustermRecords;
	}
	
	private String insertThesaurustermSql(ThesaurusRecord record) {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String toDate = record.getActiveto() != null ? "'" +simpleDateFormat.format(record.getActiveto()) + "'" : null;		
		String fromDate = record.getActivefrom() != null ? "'" + simpleDateFormat.format(record.getActivefrom()) + "'" : "null";
		
		String newLine = System.getProperty("line.separator");
		String sql = "INSERT INTO THESAURUS_TERMS "
				//+ "(THESAURUS_TERM_ID, "
				+ "(THESAURUS_TERM_ACTIVEFROM, "
				+ "THESAURUS_TERM_ACTIVETO, "
				+ "THESAURUS_TERM_LEVEL0, "
				+ "THESAURUS_TERM_LEVEL1, "
				+ "THESAURUS_TERM_LEVEL2, "
				+ "THESAURUS_TERM_LEVEL3) "
				+ "VALUES ("
				//+ record.getId() + ", "
				+ (fromDate) + ", "
				+ (toDate) + ", "
				+ (record.getLevel0() != null ? "'" + record.getLevel0().replace("'", "''")  + "'" : null) + ", "
				+ (record.getLevel1() != null ? "'" + record.getLevel1().replace("'", "''") + "'" : null) + ", "
				+ (record.getLevel2() != null ? "'" + record.getLevel2().replace("'", "''") + "'" : null) + ", "
				+ (record.getLevel3() != null ? "'" + record.getLevel3().replace("'", "''") + "'" : null) + ");"
				+ newLine;
		System.out.print(sql);
		return sql;
	}

}
