package jpa.service;

import jpa.domain.RentUnitContractItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午10:04
 */
@Service
public class ContractItemService {


    public BigDecimal doCaculteContractItem(RentUnitContractItem rentUnitContractItem) {

        if (rentUnitContractItem.isShouldNotity()) {
            BigDecimal receivableAmonut = rentUnitContractItem.caculcateReceivable();

            System.out.println("发送邮件" + receivableAmonut);
            return receivableAmonut;
        }
        return null;

    }


}
