package tech.knowdb.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tech.knowdb.blog.model.Person;
import tech.knowdb.blog.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping
	public @ResponseBody List<Person> getPersons() {
		return personRepository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Person getPerson(@PathVariable Long id) {
		return personRepository.findById(id).orElse(new Person());
	}

	@PostMapping
	public @ResponseBody Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping
	public @ResponseBody Person updatePerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personRepository.deleteById(id);
	}
}
