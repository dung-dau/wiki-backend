package com.ddau.wiki.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddau.wiki.model.Page;
import com.ddau.wiki.repository.PageRepository;

@Service
public class PageService {
	@Autowired
	private PageRepository pageRepository;
	
	public Page createPage(Page page) {
		return pageRepository.save(page);
	}
	
	public Iterable<Page> getAllPages() {
		return pageRepository.findAll();
	}
	
	public Optional<Page> getPageById(String id) {
		return pageRepository.findById(Integer.valueOf(id));
	}
	
	public void deletePage(String id) {
		pageRepository.deleteById(Integer.valueOf(id));
	}
}
