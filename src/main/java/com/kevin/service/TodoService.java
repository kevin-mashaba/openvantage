package com.kevin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.domain.Tasks;
import com.kevin.domain.Task;
import com.kevin.repository.TaskRepository;
import com.kevin.repository.TodoRepository;



@Service
public class TodoService 
{
	@Autowired
	private TaskRepository todoRepository;
	
	
	public Task createTasks(Task task)
	{
		return todoRepository.save(task);
	}
	
	public Task updateTask(long id, Task tasks)
	{
		Task t = todoRepository.getOne(id);
		
		if(t!=null)
		{
			t.setTitle(tasks.getTitle());
			t.setCategory(tasks.getCategory());
			t.setDescription(tasks.getDescription());
			t.setDate(tasks.getDate());
			t.setStatus(tasks.isStatus());
			final Task newTask = todoRepository.save(t);
			return newTask;
		}
		else
		{
			return null;
		}
	}
	
	public void deleteTask(long id)
	{
		Task t = todoRepository.getOne(id);
		if(t!=null)
		{
			todoRepository.delete(t);
		}
		else
		{
			System.err.print("Task does not exist");
			
		}
	}
	
	public List<Task> getAllTasks()
	{
		return todoRepository.findAll();
	}
}
