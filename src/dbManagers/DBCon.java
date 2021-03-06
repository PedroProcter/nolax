
package dbManagers;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBCon {
    
    private Connection con;
    private String host,port,dbname,user,pss;
    
    public DBCon(String host, String port, String dbname,String user, String pss){
        
        this.host = host;
        this.port = port;
        this.dbname = dbname;
        this.user = user;
        this.pss = pss;
        
        this.ChargeClassForName();
        this.createCon();
          
    }
    
    private void createCon(){
        
        String url = "jdbc:mysql://"+this.host+":"+this.port+"/"+this.dbname;
        try{
        
            this.con = DriverManager.getConnection(url,this.user,this.pss);
            
        }catch(Exception e){System.out.println(e);}
        
    }
    
    public void getConection(CanGetDBConnection manager){
        
        manager.setDBConnection(this.con);
        
    }
    
    private void ChargeClassForName(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        }catch(Exception e){System.out.println(e);}
    
    }
    
    
    
    
    
    
}
