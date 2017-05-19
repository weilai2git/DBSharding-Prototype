package com.future.tech.dbsharding.repository;

import org.springframework.stereotype.Repository;

import com.future.tech.dbsharding.annotation.ShardingRepository;
import com.future.tech.dbsharding.entity.Entry;


@Repository
@ShardingRepository
public interface EntryRepository {
	
	int insert(Entry entry);
}
