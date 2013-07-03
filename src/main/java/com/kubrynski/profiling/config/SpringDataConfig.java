package com.kubrynski.profiling.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-07-03
 */
@Configuration
@EnableJpaRepositories("com.kubrynski.profiling.repository")
public class SpringDataConfig {

  @Bean
  public javax.sql.DataSource dataSource() {
    EmbeddedDatabaseFactoryBean bean = new EmbeddedDatabaseFactoryBean();
    bean.setDatabaseType(EmbeddedDatabaseType.H2);
    bean.afterPropertiesSet();
    return bean.getObject();
  }

  @Bean
  public AbstractEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPackagesToScan("com.kubrynski.profiling.model");
    entityManagerFactory.setPersistenceProvider(new HibernatePersistence());
    entityManagerFactory.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create-drop");
    entityManagerFactory.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    entityManagerFactory.getJpaPropertyMap().put("hibernate.show_sql", "true");
    entityManagerFactory.getJpaPropertyMap().put("javax.persistence.validation.mode", "none");
    entityManagerFactory.afterPropertiesSet();

    return entityManagerFactory;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManagerFactory().getObject());
  }
}
