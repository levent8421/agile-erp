package com.berrontech.erp.commons.util;

import com.berrontech.erp.commons.entity.AbstractEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Create By Levent8421
 * Create Time: 2021/1/24 14:10
 * Class Name: EntityUtils
 * Author: Levent8421
 * Description:
 * 实体类工具
 *
 * @author Levent8421
 */
public class EntityUtils {
    /**
     * 将entityList转换为Map， 若List存在相同Key的数据，则保留createTime最大的那个
     *
     * @param dataList     数据
     * @param keyGenerator 指定如何生成Key
     * @param <K>          key
     * @param <V>          value
     * @return map
     */
    public static <K, V extends AbstractEntity> Map<K, V> asMapOnlyLast(List<V> dataList, Function<V, K> keyGenerator) {
        final Map<K, V> res = new HashMap<>(16);
        for (V entity : dataList) {
            final K key = keyGenerator.apply(entity);
            if (res.containsKey(key)) {
                final V exists = res.get(key);
                if (exists.getCreateTime().compareTo(entity.getCreateTime()) < 0) {
                    res.put(key, entity);
                }
            } else {
                res.put(key, entity);
            }
        }
        return res;
    }
}
