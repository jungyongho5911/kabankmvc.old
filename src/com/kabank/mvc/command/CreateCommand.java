package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class CreateCommand {
	Map<?,?> map;
public CreateCommand(HttpServletRequest request) {
	map = ParamsIterator.excute(request);
}
public void execute() {
	
}
}
