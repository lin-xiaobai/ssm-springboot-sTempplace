package CET4Web.ServiceImpl;

import CET4Web.Bean.CET4Bean;
import CET4Web.DaoImpl.DaoImpl;
import CET4Web.IDao.IDao;
import CET4Web.IService.IService;

/**
 * @date 2021/7/5 -23:48
 */
public class ServiceImpl implements IService {
    @Override
    public boolean addetc(CET4Bean cet) {
        IDao dao = new DaoImpl();
        boolean falg = false;
        int count = -1;
        if (!dao.isExist(cet)) {
            count = dao.add(cet);
            if (count > 0) falg = true;
        } else {
            falg = false;
        }
        return falg;
    }
}
