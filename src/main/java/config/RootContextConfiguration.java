package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ContextDataSource.class, ContextSqlMapper.class, ImageConfig.class })
@ComponentScan(basePackages = {"clubactivity.dao, clubactivity.service"})
public class RootContextConfiguration {

}
