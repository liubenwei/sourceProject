package com.liu.sourceProject.http.server.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liu
 * @Date 2020/11/19 13:59
 */
@Data
@Slf4j
public class NettyServerDemo {
	public static void main(String[] args) {

	}

	private void bind(int port) {
		EventLoopGroup parentGroup = new NioEventLoopGroup();
		try {

		} catch (Exception e) {
			log.info("{}", e);
		}

	}
}
