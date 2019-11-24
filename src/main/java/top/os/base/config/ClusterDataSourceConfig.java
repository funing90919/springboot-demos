package top.os.base.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, /*sqlSessionFactoryRef = "clusterSqlSessionFactory"*/ sqlSessionTemplateRef = "clusterSqlSessionTemplate")
public class ClusterDataSourceConfig {

    static final String PACKAGE = "top.os.dst.dao";
    private static final String MAPPER_LOCATION = "classpath:mybatis/dst/*.xml";

    @Value("${cluster.datasource.url}")
    private String url;  

    @Value("${cluster.datasource.username}")
    private String username;  

    @Value("${cluster.datasource.password}")
    private String password;  

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;  

    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;  

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;  

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;  

    @Value("${spring.datasource.druid.maxWait}")
    private int maxWait;  

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;  

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;  

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;  

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;  

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;  

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;  

    @Value("${spring.datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;  

    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;  

    @Value("${spring.datasource.druid.filters}")
    private String filters;  

    @Value("{spring.datasource.druid.connectionProperties}")
    private String connectionProperties;  


    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        //DruidDataSource dataSource = new DruidDataSource();
        //DruidDataSource dataSource = new DruidDataSource();
        DruidXADataSource dataSource = new DruidXADataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        //具体配置
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties(connectionProperties);

        // 分布式事务控制
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("clusterDataSource");
        ds.setMaxIdleTime(3000);
        ds.setXaDataSource(dataSource);
        return ds;
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    /*@Bean(name = "clusterTransactionManager")
    public PlatformTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }*/

    @Bean(name = "clusterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate clusterSqlSessionTemplate(@Qualifier("clusterSqlSessionFactory") SqlSessionFactory clusterSqlSessionFactory) throws Exception {
        //TransactionTemplate transactionTemplate = new TransactionTemplate(masterTransactionManager());
        //transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        //transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return new SqlSessionTemplate(clusterSqlSessionFactory);
    }
}