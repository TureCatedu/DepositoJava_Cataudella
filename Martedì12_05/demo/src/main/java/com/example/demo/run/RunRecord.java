package com.example.demo.run;

import java.time.LocalDateTime;

public record RunRecord(

    Integer id,

    String title,

    LocalDateTime startedOn,

    LocalDateTime completedOn,

    Integer miles,

    Location location

){}