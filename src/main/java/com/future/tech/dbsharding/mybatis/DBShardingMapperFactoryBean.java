package com.future.tech.dbsharding.mybatis;

import java.lang.reflect.Proxy;

import org.mybatis.spring.mapper.MapperFactoryBean;

import com.future.tech.dbsharding.annotation.ShardingRepository;
import com.future.tech.dbsharding.proxy.DBShardingMapperProxy;

public class DBShardingMapperFactoryBean<T> extends MapperFactoryBean<T> {
	@Override
	public T getObject() throws Exception {
		if (super.getMapperInterface().getAnnotation(ShardingRepository.class) != null) {
			return (T) Proxy.newProxyInstance(super.getMapperInterface().getClassLoader(),
					new Class[] { super.getMapperInterface() },
					new DBShardingMapperProxy(getSqlSession().getMapper(super.getMapperInterface())));
		} else {
			return getSqlSession().getMapper(super.getMapperInterface());
		}
	}
}
