package com.future.tech.dbsharding.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.future.tech.dbsharding.annotation.ShardingDataSourceKey;
import com.future.tech.dbsharding.router.DataSourceContextHolder;

public class DBShardingMapperProxy<T> implements InvocationHandler {

	private T mapper;

	public DBShardingMapperProxy(T mapper) {
		this.mapper = mapper;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Integer key = -1;
		for (Object object : args) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.getAnnotation(ShardingDataSourceKey.class) != null) {
					field.setAccessible(true);
					key = (Integer) field.get(object);
					break;
				}
			}
		}
		if (key > -1L) {
			if (key % 2 == 0) {
				DataSourceContextHolder.setDataSourceType("ds1");
			} else {
				DataSourceContextHolder.setDataSourceType("ds2");
			}
		}
		return method.invoke(this.mapper, args);
	}

}
