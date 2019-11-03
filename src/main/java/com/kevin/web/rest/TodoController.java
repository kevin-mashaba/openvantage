package com.kevin.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.domain.Task;
import com.kevin.domain.Tasks;
import com.kevin.service.TodoService;

@RestController
@RequestMapping(value="/todo")
public class TodoController 
{
	@Autowired
	private TodoService todoService;
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Task createTask(@Valid @RequestBody Task tasks)
	{
		return todoService.createTasks(tasks);
	}
	
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PATCH)
	public Task updateTask(@PathVariable(value="id") long id,@Valid @RequestBody Task tasks)
	{
		return todoService.updateTask(id, tasks);
	}
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable(value="id") int id)
	{
		todoService.deleteTask(id);
	}
	
	
	@RequestMapping(value="/tasks",method=RequestMethod.GET)
	public List<Task> getAllTasks()
	{
		return todoService.getAllTasks();
	}
	
}
