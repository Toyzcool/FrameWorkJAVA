package bean;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

// 配置文件和注解混合使用
// 配置文件生成对象
// 注解注入属性
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Resource(name = "orderDao123")
    private OrderDao orderDao;

    public void add(){
        System.out.println("BookService...");
        bookDao.add();
        orderDao.add();
    }
}
