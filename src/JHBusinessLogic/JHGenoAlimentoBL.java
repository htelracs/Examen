package JHBusinessLogic;

import JHDataAccess.JHGenoAlimentoDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;
import java.util.List;

public class JHGenoAlimentoBL {

    private JHCatalogoDTO jhCatalogoDTO;
    private JHGenoAlimentoDAO jhGenoAlimentoDAO = new JHGenoAlimentoDAO();
    
     public JHGenoAlimentoBL() {
    }

    public List<JHCatalogoDTO> getAll() throws Exception{
        List<JHCatalogoDTO> lst = jhGenoAlimentoDAO.jhReadAll();
        return lst;
    }
    public JHCatalogoDTO getBy(int id) throws Exception{
        jhCatalogoDTO = jhGenoAlimentoDAO.jhReadBy(id);
        return jhCatalogoDTO;
    }
}
