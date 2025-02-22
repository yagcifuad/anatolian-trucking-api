package com.javaclass.anatolianweb;

class UserNotFound extends RuntimeException {
    UserNotFound(Integer id) {
        super("Could not find user " + id);
    }
}
