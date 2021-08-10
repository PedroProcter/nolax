package dbManagers;

import java.sql.Connection;

interface CanGetDBConnection {
    /**
     * Gets a database connection
     * 
     */

     /**
      * 
      * @param dbConnection
      */
    public void setDBConnection(Connection dbConnection);
}
