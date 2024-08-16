package JHDataAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import JHDataAccess.JHDTO.JHCatalogoDTO;
import JHFramework.JHException;
import java.util.List;

public class JHGenoAlimentoDAO extends JHDataHelper implements JHIDAORead<JHCatalogoDTO> {
     @Override
    public List<JHCatalogoDTO> jhReadAll() throws Exception {
        
        List <JHCatalogoDTO> lst = new ArrayList<>();
        String query = "select * from JHVistaGenoAlimento";

        try {
            Connection jhConn  = jhOpenConnection();
            Statement jhStmt  = jhConn.createStatement();
            ResultSet jhRs    = jhStmt.executeQuery(query);

            while (jhRs.next()) {
                JHCatalogoDTO jhCatalogoDTO = new JHCatalogoDTO();
                lst.add(jhCatalogoDTO);
            }

        } catch (Exception e) {
            throw new JHException(e, getClass().getName(), "readAll()");
        }
        return lst;

    }

    @Override
    public JHCatalogoDTO jhReadBy(Integer id) throws Exception {
        JHCatalogoDTO jhCatalogoDTO = new JHCatalogoDTO();
        String query = "select * from JHVistaGenoAlimento";

        try {
            Connection jhConn  = jhOpenConnection();
            Statement jhStmt  = jhConn.createStatement();
            ResultSet jhRs    = jhStmt.executeQuery(query);
            System.out.println(query);

            while (jhRs.next()) {
                jhCatalogoDTO = new JHCatalogoDTO();
                
            }

        } catch (Exception e) {
            throw new JHException(e, getClass().getName(), "readABy()");
        }
        return jhCatalogoDTO;
    }
}
