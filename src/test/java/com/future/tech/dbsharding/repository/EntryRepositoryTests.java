package com.future.tech.dbsharding.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.future.tech.dbsharding.AbstractSpringTests;
import com.future.tech.dbsharding.entity.Entry;

public class EntryRepositoryTests extends AbstractSpringTests{
	
	@Autowired
	private EntryRepository entryRepository;
	
	@Test
	public void insert() {
		Entry entry = new Entry();
		entry.setId(4);
		entry.setUserId(4);
		entry.setMemo("Test");
		int res = entryRepository.insert(entry);
		Assert.assertTrue(res > 0);
	}
}
