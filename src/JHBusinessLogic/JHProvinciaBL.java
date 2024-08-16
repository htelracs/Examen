package JHBusinessLogic;

import JHDataAccess.JHProvinciaDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;

import java.util.List;

public class JHProvinciaBL {
    private JHCatalogoDTO jhCatalogoDTO;
    private JHProvinciaDAO  jhProvinciaDAO = new  JHProvinciaDAO();
    
    public JHProvinciaBL() {
    }

    public List<JHCatalogoDTO> getAll() throws Exception{
        List<JHCatalogoDTO> lst = jhProvinciaDAO.jhReadAll();
        return lst;
    }
    public JHCatalogoDTO getBy(int id) throws Exception{
        jhCatalogoDTO = jhProvinciaDAO.jhReadBy(id);
        return jhCatalogoDTO;
    }
    
}
