package springmvc.restful.Bean;

import java.util.UUID;

/**
 * @date 2021/10/12 -18:03
 */
public class test {
    public static void main(String[] args) {
        String uuid= null;
        for (int i = 0; i <10 ; i++) {
            uuid=UUID.randomUUID().toString();
            System.out.println(uuid);
        }

    }
}
