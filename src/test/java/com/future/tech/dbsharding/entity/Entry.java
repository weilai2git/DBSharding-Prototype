package com.future.tech.dbsharding.entity;

import java.util.Date;

import com.future.tech.dbsharding.annotation.ShardingDataSourceKey;
import com.future.tech.dbsharding.annotation.ShardingTableKey;

import lombok.Data;

@Data
public class Entry {
	private int id;
	@ShardingDataSourceKey
	@ShardingTableKey
	private int userId;
	private String memo;
	private Date createTime;
	private Date updateTime;
}
