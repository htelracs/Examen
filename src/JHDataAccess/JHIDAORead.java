package JHDataAccess;

import java.util.List;

public interface JHIDAORead <T>{
    public List<T> jhReadAll()            throws Exception;
    public T jhReadBy(Integer id)         throws Exception;
}
