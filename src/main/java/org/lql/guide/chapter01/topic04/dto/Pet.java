package org.lql.guide.chapter01.topic04.dto;

/**
 * @author: liangqinglong
 * @date: 2023-06-15 22:52
 * @description: 宠物
 */
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return type;
    }

}
