package zw.co.zetdc.handlers;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static void copyNonNullValues(Object source, Object target) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                // Handle the exception (log it or rethrow it)
                System.err.println("Error accessing field: " + field.getName() + " - " + e.getMessage());
            }
        }
    }
}
