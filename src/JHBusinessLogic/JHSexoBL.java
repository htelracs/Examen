package JHBusinessLogic;

import JHDataAccess.JHSexoDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;
import java.util.List;

public class JHSexoBL {
    private JHCatalogoDTO jhCatalogoDTO;
    private JHSexoDAO jhSexoDAO = new JHSexoDAO();
    
    public JHSexoBL() {
    }
    
    public List<JHCatalogoDTO> getAll() throws Exception{
        List<JHCatalogoDTO> lst = jhSexoDAO.jhReadAll();
        return lst;
    }
    public JHCatalogoDTO getBy(int id) throws Exception{
        jhCatalogoDTO = jhSexoDAO.jhReadBy(id);
        return jhCatalogoDTO;
    }
}
