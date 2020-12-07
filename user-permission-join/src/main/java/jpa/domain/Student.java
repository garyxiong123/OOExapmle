package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午1:41
 *
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorOptions(force=true)
@DiscriminatorValue("Student")
public class Student extends User {

	@Column
    private String studentName;

	@Column
    private String className;
}
