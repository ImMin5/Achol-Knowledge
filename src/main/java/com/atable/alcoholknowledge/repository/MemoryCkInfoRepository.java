package com.atable.alcoholknowledge.repository;

import com.atable.alcoholknowledge.model.CorkageInfo;

import java.util.*;

public class MemoryCkInfoRepository implements CorkageInfoRepository{

    private static Map<Long, CorkageInfo> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public CorkageInfo save(CorkageInfo cInfo) {
        cInfo.setId(++sequence);
        store.put(sequence, cInfo);
        return cInfo;
    }

    @Override
    public Optional<CorkageInfo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<CorkageInfo> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

    @Override
    public void checkAsCorkageStore(Long id) {
    }

    @Override
    public Long findByAddr(String Address) {
        return 0L;
    }
}
