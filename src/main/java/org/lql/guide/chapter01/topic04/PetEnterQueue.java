package org.lql.guide.chapter01.topic04;

import org.lql.guide.chapter01.topic04.dto.Pet;

/**
 * @author: liangqinglong
 * @date: 2023-06-15 23:01
 * @description: 宠物队列
 */
public class PetEnterQueue {

    private Pet pet;

    private Long count;

    public PetEnterQueue(Pet pet, Long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public Long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}
