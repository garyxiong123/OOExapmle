package jpa.domain.strategy;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/24 上午10:12
 */
public interface AvailableCollectionStrategy {

    boolean isAvailableCollection4User(String userType);
}
