package top.os.fun;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.os.fun.domain.UserVO;
import top.os.fun.repository.UserRepository;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootESTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    UserRepository userRepository;


    // 保存
    @Test
    public void add() {
        UserVO user = new UserVO();
        user.setId(1);
        user.setUserName("zhangsan");
        user.setAge(18);
        // 构建索引
        Index index = new Index.Builder(user).index("SF").type("user").build();
        try {
            // 执行保存
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 搜索
    @Test
    public void search() {
       String json = "{\"query\":{\"match\":{\"userName\":\"zhangsan\"}}}";
        Search search = new Search.Builder(json).addIndex("SF").addType("user").build();
        try {
            SearchResult result = jestClient.execute(search);
            String jsonString = result.getJsonString();
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       // ElasticsearchRepository操作ES
    @Test
    public void add2() {
        UserVO user = new UserVO();
        user.setId(2);
        user.setUserName("lisi");
        user.setAge(18);
        userRepository.index(user);
    }

    // ElasticsearchRepository操作ES
    @Test
    public void search2() {
        List<UserVO> userList = userRepository.findUserByUserNameLike("san");

    }

}

