package com.zlt.utils;

import com.zlt.entity.Permission;

import java.util.ArrayList;

public class PermissionArrayList extends ArrayList<Permission> {
    @Override
    public boolean contains(Object o) {
        if (o instanceof Permission){
            for (int i = 0; i < size(); i++) {
                if (get(i).getPid().equals(((Permission) o).getPid())) {
                    return true;
                }
            }
        }
        return false;
    }
}
