package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 랜덤한 숫자를 생성하여 List 로 반환합니다.
 *
 * @author 박세완
 */
public final class RandomNumberExtract {

    private RandomNumberExtract() {}

    private static final Random rd = new Random();

    /**
     * 랜덤한 수를 추출하는 메소드입니다.
     *
     * @param min - 추출할 숫자의 최솟값입니다.
     * @param max - 추출할 숫자의 최댓값입니다.
     * @param amount - 추출할 숫자의 개수입니다.
     * @return 랜덤한 10개의 숫자를 추출합니다.
     * @author 박세완
     */
    public static List<Integer> numberExtract(int min, int max, int amount) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> result;

        for (int i = 0; i < amount; i++) {
            integers.add(rd.nextInt(max) + min);
            result = integers.stream().distinct().collect(Collectors.toList());
            if(result.size() == 10) {
                break;
            }
        }

        return integers.stream().distinct().collect(Collectors.toList());
    }

}
