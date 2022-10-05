package com.backend.demoHabr.Users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestAddRole {

    int userId;
    String value;
}
