package com.liu.sourceProject.lock.zkByAop.config.props;

import com.liu.sourceProject.ioc.annotation.Component;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liu
 */
@Data
@Component
@ConfigurationProperties(prefix = "zk")
public class ZookeeperProps {

    /**
     * 连接地址
     */
    private String url;

    /**
     * 超时时间(毫秒)，默认1000
     */
    private int timeout = 1000;


    /**
     * 重试次数， 默认3
     */
    private int retry = 3;

}
