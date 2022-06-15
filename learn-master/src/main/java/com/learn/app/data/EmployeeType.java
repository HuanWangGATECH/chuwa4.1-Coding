package com.learn.app.data;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EmployeeType {
    MANAGER, DEVELOPER, HR;

    @JsonCreator
    public static EmployeeType forValue(String value) {
        for (EmployeeType type: EmployeeType.values()) {
            if(type.equals(value)) {
                return type;
            }
        }
        return DEVELOPER;
    }

}
