package jpa.domain;

import jpa.domain.strategy.AvailableCollectionStrategy;
import jpa.domain.vo.CollectionSettingVO;
import jpa.domain.vo.CouponCollectionSettingVO;
import jpa.domain.vo.FullSalesPromotionSettingVO;
import jpa.domain.vo.TimeSettingVO;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/24 上午9:57
 */
public class Coupon extends Promotion {

    protected FullSalesPromotionSettingVO fullSalesPromotionSettingVO;

    private AvailableCollectionStrategy availableCollectionStrategy;

    private TimeSettingVO timeSettingVO;

    private CouponCollectionSettingVO collectionSettingVO;

}
