package cn.leyizuo.springcloud.goods_server.webAPI.config;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import javax.sql.DataSource;
import java.io.IOException;


/**
* @Description:    mybatisPlusConfig配置类，如何让系统识别的呢
* @Author:         qiusheng
* @Company:
* @department:
* @CreateDate:     2019/3/13 10:04
* @UpdateUser:     qiusheng
* @UpdateDate:     2019/3/13 10:04
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
@MapperScan("cn.leyizuo.springcloud.goods_server.webAPI,mapper")
public class MybatisPlusConfig {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private MybatisProperties mybatisProperties;

    @Autowired
    private ResourceLoader resourceLoader= new DefaultResourceLoader();

    @Autowired(required=false)
    private Interceptor[] interceptors;

    @Autowired(required=false)
    private DatabaseIdProvider databaseIdProvider;

    /**
     *mybatis分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    /**
     * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
     * 配置文件和mybatis-boot的配置文件同步
     * @return
     */
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(){
        //设置数据源
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean=new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setVfs(SpringBootVFS.class);

        //设置mybatisconfig的位置
        if(StringUtils.hasText(this.mybatisProperties.getConfigLocation())){
            mybatisSqlSessionFactoryBean.setConfigLocation(this.resourceLoader.getResource(this.mybatisProperties.getConfigLocation()));
        }

        //设置拦截器
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
        if(!ObjectUtils.isEmpty(this.interceptors)){
            mybatisSqlSessionFactoryBean.setPlugins(this.interceptors);
        }

        //设置databaseIdProvider
        if(null !=this.databaseIdProvider){
            mybatisSqlSessionFactoryBean.setDatabaseIdProvider(this.databaseIdProvider);
        }

        //设置别名包
        if(StringUtils.hasText(this.mybatisProperties.getTypeAliasesPackage())){
            mybatisSqlSessionFactoryBean.setTypeAliasesPackage(this.mybatisProperties.getTypeAliasesPackage());
        }else{
            StringBuilder typeAliasPackage = new StringBuilder();
            typeAliasPackage.append("cn.leyizuo.springcloud.goods_server.webAPI.entity");
            mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage.toString());
        }

        //设置处理包
        if(StringUtils.hasText(this.mybatisProperties.getTypeHandlersPackage())){
            mybatisSqlSessionFactoryBean.setTypeHandlersPackage(this.mybatisProperties.getTypeHandlersPackage());
        }

        //资源格式解析
        ResourcePatternResolver resourcePatternResolver= new PathMatchingResourcePatternResolver();
        try{
            Resource[] serviceMapperResource = resourcePatternResolver.getResources("classPath:mapper/*.xml");
            mybatisSqlSessionFactoryBean.setMapperLocations(serviceMapperResource);
        }catch(IOException ioe){
            ioe.printStackTrace();
            throw new RuntimeException(ioe);
        }

        return mybatisSqlSessionFactoryBean;

    }

}
