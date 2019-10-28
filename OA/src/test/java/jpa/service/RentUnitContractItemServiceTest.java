package jpa.service;

import jpa.domain.Contract;
import jpa.domain.RentUnit;
import jpa.domain.RentUnitContractItem;
import jpa.domain.RentUnitContractItem4RentFee;
import jpa.domain.strategy.IncreaseStrategy;
import jpa.domain.strategy.IncreaseStrategy4FixIncrease;
import jpa.domain.strategy.PaymentType;
import jpa.domain.strategy.PaymentType4UnitPrice;
import jpa.domain.vo.PaymentPeriodVO;
import jpa.repository.ContractRepository;
import jpa.repository.RentUnitContractItemRepository;
import jpa.repository.RentUnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午10:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RentUnitContractItemServiceTest {

    @Autowired
    private RentUnitRepository rentUnitRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private RentUnitContractItemRepository rentUnitContractItemRepository;

    @Autowired
    private ContractItemService contractItemService;


    @Before
    public void setUp() throws Exception {

        System.getProperties().setProperty("spring.application.name", "ss");
    }

    @Test
    public void doCaculteContractItem() {
        Contract contract = createContract();
        List<RentUnit> rentUnits = createRentUnits(contract);

        contract.setRentUnits(rentUnits);
        contractRepository.save(contract);

        RentUnitContractItem rentUnitContractItem = rentUnitContractItemRepository.findAll().get(0);


        BigDecimal recevableAmount = contractItemService.doCaculteContractItem(rentUnitContractItem);

        System.out.println("应收" + recevableAmount);
    }

    private List<RentUnit> createRentUnits(Contract contract) {
        List<RentUnit> rentUnits = new ArrayList<>();
        RentUnit rentUnit = createRentUnit();
        rentUnit.setContract(contract);
        rentUnits.add(rentUnit);
        return rentUnits;
    }

    private Contract createContract() {
        LocalDateTime localDateTime = LocalDateTime.of(2012,11,11,1,1);
        return Contract.builder().contractTime(localDateTime).build();
    }

    private RentUnit createRentUnit() {

        RentUnit rentUnit = RentUnit.builder().acreage("110").address("闵行区").build();
        List<RentUnitContractItem> rentUnitContractItems = new ArrayList<>();
        PaymentPeriodVO paymentPeriod = new PaymentPeriodVO();
        PaymentType paymentType = new PaymentType4UnitPrice();
        //租金费
        RentUnitContractItem4RentFee rentItem = createRentUnitContractItem4RentFee(paymentPeriod, paymentType, rentUnit);

        rentUnitContractItems.add(rentItem);
        rentUnit.setRentUnitContractItemList(rentUnitContractItems);

        return rentUnit;
    }

    private RentUnitContractItem4RentFee createRentUnitContractItem4RentFee(PaymentPeriodVO paymentPeriod, PaymentType paymentType, RentUnit rentUnit) {
        RentUnitContractItem4RentFee rentItem = new RentUnitContractItem4RentFee();
        rentItem.setPaymentPeriodVO(paymentPeriod);
        rentItem.setPaymentType(paymentType);
        rentItem.setRentUnit(rentUnit);
        rentItem.setAcreage("110");
        rentItem.setRentFee(new BigDecimal(4));
        IncreaseStrategy4FixIncrease increaseStrategy = createIncreaseStrategy4FixIncrease();

        rentItem.setIncreaseStrategy(increaseStrategy);
        return rentItem;
    }

    private IncreaseStrategy4FixIncrease createIncreaseStrategy4FixIncrease() {
        IncreaseStrategy4FixIncrease increaseStrategy = new IncreaseStrategy4FixIncrease();
        increaseStrategy.setPerYear(2);
        increaseStrategy.setIncreasePercert(10);
        return increaseStrategy;
    }
}