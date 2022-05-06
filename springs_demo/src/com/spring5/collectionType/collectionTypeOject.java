package com.spring5.collectionType;

/**
 * @date 2021/7/14 -17:29
 * 在集合里面设置对象类型值，值是对象集合
 */
//创建学生所属的课
public class collectionTypeOject {
    private String couseName;

    public void setCouseName(String couseName) {
        this.couseName = couseName;
    }

    private String couseTea;

    public void setCouseTea(String couseTea) {
        this.couseTea = couseTea;
    }


    @Override
    public String toString() {
        return "collectionTypeOject{" +
                "couseName='" + couseName + '\'' +
                ", couseTea='" + couseTea + '\'' +
                '}';
    }
}
