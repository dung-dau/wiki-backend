package com.ddau.wiki.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ddau.wiki.service.PageService;
import com.ddau.wiki.model.Page;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/page")
public class PageController {
	@Autowired
	private PageService pageService;
	
	@PostMapping
	public ResponseEntity<Page> createPage(@RequestBody Page page) {
		Page createdPage = pageService.createPage(page);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdPage.getId())
				.toUri();
		return ResponseEntity.created(location).body(createdPage);
	}
	
	@GetMapping
	public @ResponseBody Iterable<Page> getAllPages() {
		System.out.println("Retrieving pages");
		return pageService.getAllPages();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Page getPageById(@PathVariable String id) {
		Optional<Page> obj = pageService.getPageById(id);
		if(obj.isPresent()) return obj.get();
		else return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Page> deletePage(@PathVariable String id) {
		System.out.println("Deleting page with id: " + id);
		pageService.deletePage(id);
		return null;
	}
}
