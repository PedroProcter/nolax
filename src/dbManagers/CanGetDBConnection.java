package dbManagers;

import java.sql.Connection;

interface CanGetDBConnection {
    /**
     * Gets a database connection
     * 
     */

     /**
      * 
      *Sets the database connection to the value provided
      *
      * @param dbConnection
      */
    public void setDBConnection(Connection dbConnection);
}
