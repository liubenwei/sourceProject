package com.liu.sourceProject.myThreadPool.listener;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.liu.sourceProject.myThreadPool.DynamicThreadPoolManager;
import com.liu.sourceProject.myThreadPool.config.DynamicThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

/**
 * @author liu
 * @Date 2020/8/16 10:07
 */
@Slf4j
public class NacosCloudConfigUpdateListener {

	@Autowired
	private NacosConfigProperties nacosConfigProperties;
	@NacosInjected
	private ConfigService configService;
	@Autowired
	private DynamicThreadPoolManager dynamicThreadPoolManager;
	@Autowired
	private DynamicThreadPoolProperties dynamicThreadPoolProperties;

	@PostConstruct
	private void init() {
		initConfigUpdateListener();
	}

	private void initConfigUpdateListener() {
//		Assert.has(dynamicThreadPoolProperties.);
	}

}
