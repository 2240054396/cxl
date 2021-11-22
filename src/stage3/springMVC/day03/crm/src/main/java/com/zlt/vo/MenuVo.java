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
public class MenuVo {
    private MenuInfo homeInfo;
    private MenuInfo logoInfo;
    private List<MenuInfo> menuInfo;
}
