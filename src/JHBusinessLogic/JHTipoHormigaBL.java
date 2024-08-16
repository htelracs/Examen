package JHBusinessLogic;

import java.util.List;

import JHDataAccess.JHTipoHormigaDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;

public class JHTipoHormigaBL {
    
    private JHCatalogoDTO jhCatalogoDTO;
    private JHTipoHormigaDAO jhTipoHormigaDAO = new JHTipoHormigaDAO();
    
    
    public JHTipoHormigaBL() {
    }
    
    public List<JHCatalogoDTO> getAll() throws Exception{
        List<JHCatalogoDTO> lst = jhTipoHormigaDAO.jhReadAll();
        return lst;
    }
    public JHCatalogoDTO getBy(int idTipoHormiga) throws Exception{
        jhCatalogoDTO = jhTipoHormigaDAO.jhReadBy(idTipoHormiga);
        return jhCatalogoDTO;
    }

}
