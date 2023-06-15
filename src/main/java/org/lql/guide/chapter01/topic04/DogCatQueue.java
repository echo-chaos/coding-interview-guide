package org.lql.guide.chapter01.topic04;

import org.lql.guide.chapter01.topic04.dto.Cat;
import org.lql.guide.chapter01.topic04.dto.Dog;
import org.lql.guide.chapter01.topic04.dto.Pet;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: liangqinglong
 * @date: 2023-06-15 23:06
 * @description: 猫狗队列
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;

    private Queue<PetEnterQueue> catQ;

    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    /**
     * 将cat或dog实例放入队列中
     *
     * @param pet 宠物
     * @return:
     * @author: liangqinglong
     * @date: 2023-06-15 23:24
     **/
    public void add(Pet pet) {
        if (Objects.equals(pet.getPetType(), "dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (Objects.equals(pet.getPetType(), "cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    /**
     * 将队列中所有的实例按照进队列顺序依次弹出
     *
     * @return: 队列中的宠物实例
     * @author: liangqinglong
     * @date: 2023-06-15 23:24
     **/
    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    /**
     * 将队列中的dog实例按照进队列顺序依次弹出
     *
     * @return: dog
     * @author: liangqinglong
     * @date: 2023-06-15 23:25
     **/
    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    /**
     * 将队列中的cat实例按照进队列顺序依次弹出
     *
     * @return: cat
     * @author: liangqinglong
     * @date: 2023-06-15 23:26
     **/
    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    /**
     * 检查队列中是否还有dog或cat实例
     *
     * @return: 结果
     * @author: liangqinglong
     * @date: 2023-06-15 23:26
     **/
    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    /**
     * 检查队列中是否有dog实例
     *
     * @return:
     * @author: liangqinglong
     * @date: 2023-06-15 23:27
     **/
    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    /**
     * 检查队列中是否有cat实例
     *
     * @return:
     * @author: liangqinglong
     * @date: 2023-06-15 23:28
     **/
    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}
