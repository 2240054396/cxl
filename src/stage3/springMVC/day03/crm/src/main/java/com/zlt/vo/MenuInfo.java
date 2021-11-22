package com.zlt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuInfo {
    private Long mid;
    private int level;
    private String title;
    private String icon;
    private String herf;
    private String target;
    private String image;
    private List<MenuInfo> child;
}
