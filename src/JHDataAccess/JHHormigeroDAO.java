package JHDataAccess;

import java.sql.Connection;
import java.util.List;

import JHDataAccess.JHDTO.JHHormigeroDTO;
import JHFramework.JHException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JHHormigeroDAO extends JHDataHelper implements JHIDAO<JHHormigeroDTO>{

    @Override
    public boolean jhCreate(JHHormigeroDTO entity) throws Exception {
        String query = "INSERT INTO JHHormigero "
                     + "(Tipo hormiga, IdCatalogoSexo, IdCatalogoProvincia, IdCatalogoGenoAlimento, IdCatalogoIngestaNativa ) VALUES (?,?,?,?,?)"  ;
        
        try {
            Connection jhConn = jhOpenConnection();
            PreparedStatement jhpstmt = jhConn.prepareStatement(query);
            jhpstmt.setInt(1, entity.getTipoHormiga());
            jhpstmt.setInt(2, entity.getIdCatalogoSexo());  
            jhpstmt.setInt(3, entity.getIdCatalogoProvincia());
            jhpstmt.setInt(4, entity.getIdCatalogoGenoAlimento());
            jhpstmt.setInt(5, entity.getIdCatalogoIngestaNativa());
            jhpstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            throw new JHException(e, getClass().getName(), "create()");
        }
    }

    @Override
    public List<JHHormigeroDTO> jhReadAll() throws Exception {
        List <JHHormigeroDTO> lst = new ArrayList<>();
        String query = "SELECT JHHormigero"
                     + " , IdHormiga              "
                     + " , TipoHormiga            "
                     + " , IdCatalogoSexo         "
                     + " , IdCatalogoProvincia    "
                     + " , IdCatalogoGenoAlimento "
                     + " , IdCatalogoIngestaNativa"
                     + " , Estado                 "
                     + " , FechaCracion           "
                     + " , FechaModifica          "

                     + " FROM JHHormiga           "
                     + " WHERE Estado = 'A'       ";

        try {
            Connection jhConn = jhOpenConnection();
            Statement jhStmt  = jhConn.createStatement();
            ResultSet jhRs    = jhStmt.executeQuery(query);
            
            while (jhRs.next()) { 
                JHHormigeroDTO jhHormigeroDTO = new JHHormigeroDTO(jhRs.getInt(1)
                                                            ,jhRs.getInt(2)
                                                            ,jhRs.getInt(3)
                                                            ,jhRs.getInt(4)
                                                            ,jhRs.getInt(5)
                                                            ,jhRs.getInt(6)
                                                            ,jhRs.getString(7)
                                                            ,jhRs.getString(8)
                                                            ,jhRs.getString(9));
             lst.add(jhHormigeroDTO);                                       
            }                                                         
        } catch (SQLException e) {
            throw new JHException(e, getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean jhUpdate(JHHormigeroDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE JHHormigero SET TipoHormiga = ?, IdCatalogoSexo =?, IdCatalogoProvincia = ?, IdCatalogoGenoAlimento = ?, IdCatalogoIngestaNativa = ?, FechaModifica = ? WHERE IdHJHormiga = ?";
        try {
            Connection jhConn = jhOpenConnection();
            PreparedStatement jhPstmt = jhConn.prepareStatement(query);
            jhPstmt.setInt(1, entity.getTipoHormiga());
            jhPstmt.setInt(2, entity.getIdCatalogoSexo());
            jhPstmt.setInt(3, entity.getIdCatalogoProvincia());
            jhPstmt.setInt(4, entity.getIdCatalogoGenoAlimento());
            jhPstmt.setInt(5, entity.getIdCatalogoIngestaNativa());
            jhPstmt.setString(6, dtf.format(now).toString());
            jhPstmt.setInt(7, entity.getIdHormiga());
            jhPstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new JHException(e, getClass().getName(), "update()");
        }
    }

    @Override
    public boolean jhDelete(int id) throws Exception {
        String query = " UPDATE JHHormigero SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          jhConn = jhOpenConnection();
            PreparedStatement  jhPstmt = jhConn.prepareStatement(query);
            jhPstmt.setString(1, "X");
            jhPstmt.setInt(2, id);
            jhPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new JHException(e, getClass().getName(), "delete()");
        }
    }

    @Override
    public JHHormigeroDTO jhReadBy(Integer id) throws Exception {
       JHHormigeroDTO jhHormigeroDTO = new JHHormigeroDTO();
       String query = "SELECT JHHormigero"
                     + " , IdHormiga              "
                     + " , TipoHormiga            "
                     + " , IdCatalogoSexo         "
                     + " , IdCatalogoProvincia    "
                     + " , IdCatalogoGenoAlimento "
                     + " , IdCatalogoIngestaNativa"
                     + " , Estado                 "
                     + " , FechaCracion           "
                     + " , FechaModifica          "

                     + " FROM JHHormiga           "
                     + " WHERE Estado = 'A'       "
                     + "  AND IdHormiga =" + id.toString();

        try {
            Connection jhConn = jhOpenConnection();
            Statement jhStmt  = jhConn.createStatement();
            ResultSet jhRs    = jhStmt.executeQuery(query);
            System.out.println(query);

            while (jhRs.next()) { 
                 jhHormigeroDTO = new JHHormigeroDTO(jhRs.getInt(1)
                                                            ,jhRs.getInt(2)
                                                            ,jhRs.getInt(3)
                                                            ,jhRs.getInt(4)
                                                            ,jhRs.getInt(5)
                                                            ,jhRs.getInt(6)
                                                            ,jhRs.getString(7)
                                                            ,jhRs.getString(8)
                                                            ,jhRs.getString(9));                                      
            }      

        } catch (Exception e) {
            throw new JHException(e, getClass().getName(), "readAll()");
        }
        return jhHormigeroDTO;
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    JHHormigero         "
                     +" WHERE   Estado ='A'      ";
        try {
            Connection jhConn = jhOpenConnection();         
            Statement  jhStmt = jhConn.createStatement();      
            ResultSet jhRs   = jhStmt.executeQuery(query);  
            while (jhRs.next()) {
                return jhRs.getInt(1);                
            }
        } 
        catch (SQLException e) {
            throw new JHException(e, getClass().getName(), "getRowCount()");
        }
        return 0;
    }
}
