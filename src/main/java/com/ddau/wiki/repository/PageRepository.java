package com.ddau.wiki.repository;

import org.springframework.data.repository.CrudRepository;

import com.ddau.wiki.model.Page;

public interface PageRepository extends CrudRepository<Page, Integer> {
	
}