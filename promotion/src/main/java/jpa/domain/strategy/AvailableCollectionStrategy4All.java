package jpa.domain.strategy;

import jpa.domain.vo.CollectionSettingVO;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/24 上午10:13
 */
public class AvailableCollectionStrategy4All implements AvailableCollectionStrategy {
    @Override
    public boolean isAvailableCollection4User(String userType) {
        return false;
    }
}
