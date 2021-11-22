package com.zlt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    private Long cid;

    private Long uid;

    private Long wid;

    private String ccontent;

    private Date sendtime;

    private Integer state;

}
