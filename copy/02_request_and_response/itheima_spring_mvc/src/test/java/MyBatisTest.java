///**
// * @author XUAN
// * @date 2020/10/7 - 20:34
// * @references
// * @purpose
// * @errors
// */
//
//import domain.Result;
//import domain.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class MyBatisTest {
//
////    @Test
//    //插入操作
//    public void save(Result result) throws IOException {
//
//        //模拟user对象
////        Result result = new Result();
//        //不改代码就运行，第二此运行时会报错，因为 id 为主键
////        result.setId(47);
////        result.setAvg_integral(123);
////        result.setAvg_remaining(456);
//
//        //获得核心配置文件
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //获得session工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        //获得session回话对象
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);//在此设置为 true ，后面就不用手动提交
//        //执行操作  参数：namespace+id
//        sqlSession.insert("userMapper.save",result);
//
//        //mybatis执行更新操作  提交事务
//        sqlSession.commit();
//
//        //释放资源
//        sqlSession.close();
//    }
//
////    @Test
//    //查询一个对象
//    public List<User> findById(int id) throws IOException {
//        //获得核心配置文件
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //获得session工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        //获得session回话对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //执行操作  参数：namespace+id
//        List<User> userList = sqlSession.selectList("userMapper.findById",id);
//
////        User user = sqlSession.selectOne("userMapper.findById", 1);
//        //打印数据
//        System.out.println(userList);
//        //释放资源
//        sqlSession.close();
//        return userList;
//    }
//
//
//
////    @Test
////    public void t() throws IOException {
////        List<User> userList = findById(123456789);
////        Result result = new Result();
////        System.out.println(result.countAvg_remaining(userList));
////        System.out.println(result.countAvg_integral(userList));
////
////        result.setId(123456789);
////        result.setAvg_remaining(result.countAvg_remaining(userList));
////        result.setAvg_integral(result.countAvg_integral(userList));
////
////        save(result);
////    }
//
//}
