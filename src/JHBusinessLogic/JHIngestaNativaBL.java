package JHBusinessLogic;

import JHDataAccess.JHIngestaNativaDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;
import java.util.List;

public class JHIngestaNativaBL {

    private JHCatalogoDTO jhCatalogoDTO;
    private JHIngestaNativaDAO jhIngestaNativaDAO = new JHIngestaNativaDAO();
   
    public JHIngestaNativaBL() {
    }

    public List<JHCatalogoDTO> getAll() throws Exception{
        List<JHCatalogoDTO> lst = jhIngestaNativaDAO.jhReadAll();
        return lst;
    }
    public JHCatalogoDTO getBy(int id) throws Exception{
        jhCatalogoDTO = jhIngestaNativaDAO.jhReadBy(id);
        return jhCatalogoDTO;
    }
    
}
