package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:10
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class AccountConfig {

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 账单文件地址
     */
    private String billFilePath;
}
