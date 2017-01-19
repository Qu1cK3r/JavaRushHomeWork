package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.size() == 0)
            return result;
        //result.append("\"");
        for(Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null)
                result.append(String.format("%s = \'%s\' and ", entry.getKey(), entry.getValue()));
        }
        result.setLength(result.length() - 5);// 5 - это null

        return result;
    }
}
