package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.StateMapper;
import com.book.pojo.State;
import com.book.service.StateService;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	StateMapper mapper;
	
	@Override
	public void addState(State state) {
		mapper.addState(state);
	}

	@Override
	public void deleteState(int id) {
		mapper.deleteState(id);
	}

	@Override
	public void updateState(State state) {
		mapper.updateState(state);
	}

	@Override
	public List<State> getAllState() {
		return mapper.getAllState();
	}

	@Override
	public State getState(int id) {
		return mapper.getState(id);
	}

	@Override
	public State get_nameState(String name) {
		return mapper.get_nameState(name);
	}

}
