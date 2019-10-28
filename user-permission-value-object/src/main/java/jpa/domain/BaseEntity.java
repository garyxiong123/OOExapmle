package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午4:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaseEntity {



    private String createAuthor;
    private LocalDateTime createTime;
    private String updateAuthor;
    private LocalDateTime updateTime;
}
