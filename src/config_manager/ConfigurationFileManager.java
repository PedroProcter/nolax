/**
 * 
 */
package config_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author The Gentleman
 *
 */
public class ConfigurationFileManager {
	/**
	 * Provides methods to work with the configuration file(txt).
	 * */
	
	private final String configurationFileUbication = "config.txt";
	private File configurationFile;
	
	private String fileContent  = "";
	
	/**
	 * Loads the configuration file.
	 */
	public ConfigurationFileManager() {
		this.configurationFile = new File(this.configurationFileUbication);
		try {
			this.configurationFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the content of the configuration file.
	 * */
	public void loadContent() {
		try {
			Scanner fileScanner = new Scanner(this.configurationFile);
			
			while(fileScanner.hasNext()) {
				this.setFileContent(this.getFileContent() + fileScanner.nextLine() + "\n");
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a new file content for the configuration file.
	 */
	public void writeContent() {
		try {
			FileWriter configFileWriter = new FileWriter(this.configurationFile, false);
			configFileWriter.write(this.fileContent);
			configFileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the fileContent
	 */
	public String getFileContent() {
		return fileContent;
	}

	/**
	 * @param fileContent the fileContent to set
	 */
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}
