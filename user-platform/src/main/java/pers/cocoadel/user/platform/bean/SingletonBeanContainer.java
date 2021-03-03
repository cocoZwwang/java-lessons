package pers.cocoadel.user.platform.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonBeanContainer {

    private static final SingletonBeanContainer INSTANCE = new SingletonBeanContainer();

    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    public static SingletonBeanContainer getInstance() {
        return INSTANCE;
    }

    private SingletonBeanContainer() {

    }

    public <T> void put(Class<T> clazz, T object) {
        beanMap.put(clazz,object);
    }

    public <T> T get(Class<T> clazz){
        Object obj = beanMap.get(clazz);
        return obj == null ? null : clazz.cast(obj);
    }

    public void clear(){
        beanMap.keySet().forEach(beanMap::remove);
    }
}
