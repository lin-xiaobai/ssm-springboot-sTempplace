package springmvc.restful.dao;

import org.springframework.stereotype.Repository;
import springmvc.restful.Bean.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/9/13 -21:20
 */
//将EmployeeDao类加上标识，持久层注解
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    static {
        employees=new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"e_aa","aa@163.com",1));
        employees.put(1002,new Employee(1002,"e_bb","bb@163.com",0));
        employees.put(1003,new Employee(1003,"e_cc","cc@163.com",1));
        employees.put(1004,new Employee(1004,"e_dd","dd@163.com",0));
        employees.put(1005,new Employee(1005,"e_ee","ee@163.com",1));
    }
    private  static Integer initId=1006;
//    save方法可能是添加、修改功能
    public void save(Employee employee){
//        这个判断不仅仅是 添加而且还是修改
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee get(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }
}
