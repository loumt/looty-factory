/**
 * Copyright (c) www.bugull.com
 */
package NiuKeWangZhenTi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package NiuKeWangZhenTi
 * @date 2017/3/22/022
 */
public class MyCdTest {

    private static final int CD_MUSIC_LIMIT = 13;
    private static final int MUSIC_LIMIT_INTERVAL = 1;


    public static void main(String[] args) {
        String getInfo = new Scanner(System.in).nextLine();
        String[] info = getInfo.split(" +");
        int count = Integer.valueOf(info[0]);//数量
        int length = Integer.valueOf(info[1]);//每首的长度
        int capacity = Integer.valueOf(info[2]);//CD容量

        int cd_count = getCdCount(count, length, capacity);
        System.out.println(cd_count);
    }


    private static int getCdCount(int count, int length, int capacity) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int result = 1;
        //CD初始容量
        int init_capacity = capacity;
        //CD剩余容量
        int surplusCapacity = capacity;
        while (count > 0) {
            if (map.size() == 0) {//放入第一张专辑
                surplusCapacity = surplusCapacity - length;
                map.put(result, 1);
            } else {
                //现CD Music数量
                Integer cd_music = map.get(result);
                //判断是或否需要换新的
                if (validate(cd_music, surplusCapacity, length)) {
                    Integer s = map.get(result);
                    s++;
                    map.put(result, s);
                    surplusCapacity = surplusCapacity - length - MUSIC_LIMIT_INTERVAL;
                } else {
                    surplusCapacity = init_capacity - length;
                    map.put(++result, 1);
                }
            }
            count--;
        }
        //若最后一张CD music Count是13 的倍数,则CD+1
        if (checkMapMusicCount(map, result)) result++;
        return result;
    }

    /**
     * 重新检查最后一张CD
     *
     * @param result
     * @param key
     */
    private static boolean checkMapMusicCount(Map<Integer, Integer> result, int key) {
        return (result.get(key) % CD_MUSIC_LIMIT) == 0;
    }

    /**
     * @param cd_music        当前CD中的歌曲数量(不应该是13的倍数)
     * @param surplusCapacity 当前CD余量
     * @param length          歌曲大小
     * @return
     */
    private static boolean validate(Integer cd_music, int surplusCapacity, int length) {
        if ((cd_music + 1) % CD_MUSIC_LIMIT == 0) {
            int plimit = 2 * (length + MUSIC_LIMIT_INTERVAL);
            return surplusCapacity > plimit;
        } else {
            return surplusCapacity > (length + MUSIC_LIMIT_INTERVAL);
        }
    }


}
