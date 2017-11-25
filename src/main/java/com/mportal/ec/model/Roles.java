package com.mportal.ec.model;

public enum Roles {
	ADMIN, PREMIUM_MEMBER, MEMBER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
