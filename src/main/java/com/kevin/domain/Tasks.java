package com.kevin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="category")
	private String category;
	@Column(name="description")
	private String description;
	@Column(name="due_date")
	private Date date;
	@Column(name="status")
	private Boolean status;

	public Tasks(int id, String title, String category, String description, Date date, Boolean status) 
	{
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.date = date;
		this.status = status;
	}

	public Tasks() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public Boolean getStatus() 
	{
		return status;
	}

	public void setStatus(Boolean status) 
	{
		this.status = status;
	}
	

	
}
