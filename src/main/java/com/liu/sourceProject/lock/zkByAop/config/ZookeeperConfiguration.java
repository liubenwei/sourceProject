package com.liu.sourceProject.lock.zkByAop.config;

import com.liu.sourceProject.lock.zkByAop.config.props.ZookeeperProps;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu
 */
@Configuration
@EnableConfigurationProperties(ZookeeperProps.class)
public class ZookeeperConfiguration {

    private final ZookeeperProps zookeeperProps;

    @Autowired
    public ZookeeperConfiguration(ZookeeperProps zookeeperProps) {
        this.zookeeperProps = zookeeperProps;
    }


    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(zookeeperProps.getTimeout(), zookeeperProps.getRetry());
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperProps.getUrl(), retryPolicy);
        client.start();
        return client;
    }
}















