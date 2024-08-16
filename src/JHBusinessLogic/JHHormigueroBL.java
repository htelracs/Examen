package JHBusinessLogic;

import java.util.List;
import JHDataAccess.JHHormigeroDAO;
import JHDataAccess.JHDTO.JHHormigeroDTO;

public class JHHormigueroBL {
    private JHHormigeroDTO jhHormigeroDTO;
    private JHHormigeroDAO jhHormigeroDAO = new JHHormigeroDAO();
    
    public JHHormigueroBL() {
    }
    
    public List<JHHormigeroDTO> getAll() throws Exception{
        List<JHHormigeroDTO> lst = jhHormigeroDAO.jhReadAll();
        return lst;
    }
    public JHHormigeroDTO getBy(int idHormiguero) throws Exception{
        jhHormigeroDTO = jhHormigeroDAO.jhReadBy(idHormiguero);
        return jhHormigeroDTO;
    }
    public boolean add(JHHormigeroDTO jhHorDTO) throws Exception{   
        return jhHormigeroDAO.jhCreate(jhHorDTO);
    }
    public boolean update(JHHormigeroDTO jhHorDTO) throws Exception{
        return jhHormigeroDAO.jhUpdate(jhHorDTO);
    }
    public boolean delete(int idHormiguero) throws Exception{
        return jhHormigeroDAO.jhDelete(idHormiguero);
    }
    public Integer getRowCount() throws Exception{
        return jhHormigeroDAO.getRowCount();
    }

}
