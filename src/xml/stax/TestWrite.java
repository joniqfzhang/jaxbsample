package xml.stax;

public class TestWrite {

	public static void main(String[] args) {
		StaxWriter configFile = new StaxWriter();
        configFile.setConfigFile("config2.xml");
        try {
            configFile.saveConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
