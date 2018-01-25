package com.componentwise.eval;

import java.util.NoSuchElementException;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class UserKey {

	private String name;
	private String userid;

	public UserKey(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userid;
	}
	
	Optional<UserKey> cast(Object object){
		try{
		    return of(getClass().cast(object));
		}catch(ClassCastException cause){
			return empty();
		}
	}
	
	
	boolean evaluate(Optional<Boolean> delta){
		try{
			return delta.get();
		}catch(NoSuchElementException cause) {
			return false;
		}
	}
	
	@Override
	public boolean equals(final Object other){
	    return evaluate(cast(other).map(othr -> of(this.name).equals(of(othr.name))));
	}
}
	
