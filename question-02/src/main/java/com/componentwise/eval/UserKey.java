package com.componentwise.eval;

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

	@Override
	public boolean equals(final Object other){
	    return other instanceof UserKey ? ((UserKey)(other)).equals(this) : false;
	}
	
	private boolean equals(UserKey other){
		if(this.name==null){
			return false;
		}else if(this.userid==null){
			return false;
		}else{
			return this.name.equals(other.name) && this.userid.equals(other.userid);
		}
	}
}
	
