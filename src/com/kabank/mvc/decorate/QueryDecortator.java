package com.kabank.mvc.decorate;


public class QueryDecortator implements IQuery {
	protected IQuery query;
	public QueryDecortator(IQuery query) {
		this.query = query;
	}
	@Override
	public Object execute() {
		return query.execute();
	}
	
}
