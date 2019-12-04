package com.tsyj;

import com.google.common.collect.Lists;
import com.tsyj.model.User;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: guos
 * @date: 2019/9/5$ 12:04$
 **/
public class Test {

    private static final String OPEN_TOKEN = "#{";
    private static final int OPEN_TOKEN_LENGTH = OPEN_TOKEN.length();
    private static final String REPLACE_TOKEN = "?";
    private static final String CLOSE_TOKEN = "}";
    private static final int CLOSE_TOKEN_LENGTH = CLOSE_TOKEN.length();

    public static void main(String[] args) {
        InputStream is = Test.class
                .getClassLoader()
                .getResourceAsStream(
                        "org/mybatis/generator/config/xml/mybatis-generator-config_1_0.dtd"); //$NON-NLS-1$
        InputSource ins = new InputSource(is);
        String sql = "select * from user where id=#{id}";
        int index = sql.indexOf(OPEN_TOKEN);
        int closeIndex = sql.indexOf(CLOSE_TOKEN, index);
        String param = sql.substring(index + OPEN_TOKEN_LENGTH, closeIndex);
        System.out.println("id:" + param);
        StringBuilder sb = new StringBuilder();
        sb.append(sql, 0, index).append(REPLACE_TOKEN);
        System.out.println(sb.toString());

        List<User> userList = Lists.newArrayList();
        User user1 = new User();
        user1.setId(1);
        user1.setName("gs");

        User user2 = new User();
        user1.setId(1);
        user1.setName("tsyj");

        User user3 = new User();
        user3.setId(1);
        user3.setName("guos");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        //Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, u -> u, (k1, k2) -> k2));
        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        for (Integer id : userMap.keySet()) {
            System.out.println("key :" +id + " "+userMap.get(id).getName());
        }
    }
}
