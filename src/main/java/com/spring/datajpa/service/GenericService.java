package com.spring.datajpa.service;

import java.util.List;

public interface GenericService<T> {
	
	public T save(T objeto);
	public List<T> list();
	
}
