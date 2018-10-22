package com.codecool;

import java.util.Map;

class TimersDisplay {

    void displayTimers(Map<String, Timer> timerMap) {
        for (String key : timerMap.keySet()) {
            Timer timer = timerMap.get(key);
            String template = "Name: %s, ThreadId: %s, Seconds: %s";
            System.out.println(String.format(template, key, timer.getId(), timer.getSecondsPassed()));
        }
    }
}
