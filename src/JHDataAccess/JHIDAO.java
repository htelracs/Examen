package JHDataAccess;

import java.util.List;

public interface JHIDAO<T> {
    public boolean jhCreate(T entity)     throws Exception;
    public List<T> jhReadAll()            throws Exception;
    public boolean jhUpdate(T entity)     throws Exception;
    public boolean jhDelete(int id)       throws Exception;
    
    public T jhReadBy(Integer id)         throws Exception;
}
