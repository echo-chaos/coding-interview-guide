package org.lql.guide.chapter01.topic04;

import org.lql.guide.chapter01.topic03.ReverseOrderStackTest;
import org.lql.guide.chapter01.topic04.dto.Cat;
import org.lql.guide.chapter01.topic04.dto.Dog;
import org.lql.guide.chapter01.topic04.dto.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liangqinglong
 * @date: 2023-06-15 23:28
 * @description:
 */
public class DogCatQueueTest {

    private static final Logger logger = LoggerFactory.getLogger(ReverseOrderStackTest.class);

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        Pet[] pets = new Pet[]{new Cat(), new Dog(), new Dog(), new Cat(), new Dog(), new Cat()};
        logger.info("检查队列中是否还有dog或cat实例：{}", queue.isEmpty());
        for (int i = 0; i < pets.length; i++) {
            logger.info("依次入队的宠物：第{}只，{}", i + 1, pets[i].getPetType());
            queue.add(pets[i]);
        }
        for (int i = 0; i < pets.length; i++) {
            Pet pet = queue.pollAll();
            logger.info("按照进队列顺序依次弹出：第{}只,{}", i + 1, pet.getPetType());
        }
    }
}
