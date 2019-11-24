package top.os.fun.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.os.fun.domain.UserVO;

import java.util.List;

/**
 * Created by Jacky on 2019-05-30 22:03.
 */
public interface UserRepository extends ElasticsearchRepository<UserVO, Integer> {

    // 官方文档：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.8.RELEASE/reference/html/#elasticsearch.repositories
    List<UserVO> findUserByUserNameLike(String userName);
}
