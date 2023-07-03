package com.springdatajpa.onemany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.onemany.entity.Child;
import com.springdatajpa.onemany.entity.Parent;
import com.springdatajpa.onemany.repository.ChildRepository;
import com.springdatajpa.onemany.repository.ParentRepository;

@RestController
@RequestMapping("/parents")
public class ParentController {

	 	@Autowired
	    private ParentRepository parentRepository;
	 	
	 	@Autowired
	 	private ChildRepository childRepository;

	    @PostMapping
	    public Parent createParent(@RequestBody Parent parent) {
	        return parentRepository.save(parent);
	    }

	    @GetMapping("/{parentId}")
	    public Parent getParent(@PathVariable Long parentId) {
	        return parentRepository.findById(parentId).orElse(null);
	    }
	    @PostMapping("/child")
	    public Child createChild(@RequestBody Child child) {
	        return childRepository.save(child);
	    }
	    
	    
	    @PutMapping("/{parentId}")
	    public Parent updateParent(@PathVariable Long parentId, @RequestBody Parent updatedParent) {
	        return parentRepository.findById(parentId).map(parent -> {
	            parent.setName(updatedParent.getName());
	            return parentRepository.save(parent);
	        }).orElse(null);
	    }

	    @DeleteMapping("/{parentId}")
	    public ResponseEntity<?> deleteParent(@PathVariable Long parentId)
	    {
	        return parentRepository.findById(parentId).map(parent -> {
	            parentRepository.delete(parent);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	    }
}
