package itransition.intern.itransitioncollection.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@ToString
public class CustomHashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable, Map<K, V> {

    private int maxSize = 3;
    private Map<K, V> map;

    public CustomHashMap() {
        this.map = new HashMap<K, V>();
    }

    public CustomHashMap(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<K, V>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public V put(K key, V value) {
        if (map.size() >= maxSize && !map.containsKey(key)) {
            throw new RuntimeException("CUSTOM_HASH_MAP_IS_FILLED");
        } else {
            return map.put(key, value);
        }
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public CustomHashMap<K, V> clone() {
        try {
            CustomHashMap clone = (CustomHashMap) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}