package com.github.chandrapalsd.rbapi.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private String username;
    private final String jwttoken;
    public JwtResponse(String jwttoken, String username) {
        this.jwttoken = jwttoken;
        this.username = username;
    }
    public String getToken() {
        return this.jwttoken;
    }
    public String getUsername() {
        return this.username;
    }
}
