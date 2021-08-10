package config_manager;

public class ConfigParser {
    /**
     * 
     * ConfigParser provide methods to analize and get of the tags from the configuration file
     * 
     */
    
    String configFileContent;

    /**
     * 
     * Sets configFleContent
     * 
     * @param fileContent
     */
    public ConfigParser(String fileContent){
        this.configFileContent = fileContent;
    }

    /**
     * 
     * Search and return the value of an Attribute by it's name
     * 
     * @param attributeName
     * @return The value an attribute tag
     */
    public String getAttributeValueForName(String attributeName) {
        String output = null;

        String[] toAnalize = this.configFileContent.split("\n");

        for (String line: toAnalize) {
            if (line.contains(String.format("<%s>", attributeName))) {
                output = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<"));
            }
        }

        return output;
    }

}
