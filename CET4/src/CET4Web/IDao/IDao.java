package CET4Web.IDao;

import CET4Web.Bean.CET4Bean;

/**
 * @date 2021/7/5 -23:46
 */
public interface IDao {
    public CET4Bean querys(CET4Bean cet);

    public int add(CET4Bean cet);

    public boolean isExist(CET4Bean cet);
}
