package org.lql.guide.chapter01.topic06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2023-06-17 20:10
 * @description: 汉诺塔-非递归，栈模拟汉诺塔
 */
public class HanoiTower02 {

    private static final Logger logger = LoggerFactory.getLogger(HanoiTower02.class);

    /**
     * 大小原则：汉诺塔从栈顶到栈底数据为递减
     * 相邻两塔动作不可逆：不会出现[LToM->MToL][MToR->RToM]
     * 前置动作：L -> M:[MToR,RToM]
     * 前置动作：M -> L:[MToR,RToM]
     * 前置动作：M -> R:[MToL,LToM]
     * 前置动作：R -> M:[MToL,LToM]
     */
    public static int hanoiTower(int num, String left, String mid, String right) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        // 栈中压入边界值，避免初次比较空栈报错
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        // 从num开始由大到小依次入左栈
        for (int i = num; i > 0; i--) {
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        // 如果右栈的个数不等于num+1说明还没有移动完
        while (rs.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, ls, ms, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, ms, rs, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rs, ms, right, mid);
        }
        return step;
    }

    /**
     * 判断从 来源栈->目标栈 移动是否可行，行则移动
     *
     * @param record 记录上一次移动动作
     * @param disAct 与当前动作不允许的前置动作
     * @param nowAct 当前动作
     * @param fStack 来源栈
     * @param tStack 目标站
     * @param from   来源位置
     * @param to     目标位置
     * @return: 移动次数
     * @author: liangqinglong
     * @date: 2023-06-18 1:05
     **/
    public static int fStackTotStack(Action[] record, Action disAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        // 是否满足：相邻两塔动作关系 && 塔间层级数据大小关系
        if (record[0] != disAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            logger.info("Move {} from {} to {}", tStack.peek(), from, to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 10;
        int times = hanoiTower(n, "left", "mid", "right");
        logger.info("{} 层汉诺塔移动次数 {}", n, times);
    }
}
