package jpa.domain.strategy;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/24 上午10:13
 */
public class AvailableCollectionStrategy4RegistriedUser implements AvailableCollectionStrategy {
    @Override
    public boolean isAvailableCollection4User(String userType) {
        return false;
    }
}
