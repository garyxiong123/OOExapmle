/*
 *    Copyright 2018-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

/**
 * @author pqq
 * @version v1.0
 * @date 2019年6月27日 10:00:00
 * @work 用户
 * <p>
 * 三、每个具体的类一个表的策略
 * 这种映射策略每个类都会映射成一个单独的表，类的所有属性，包括继承的属性都会映射成表的列。
 * 这种映射策略的缺点是：对多态关系的支持有限，当查询涉及到类继承结构时通常需要发起SQL UNION查询。实例如下
 */


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING, length = 30)
public class User {

    /**
     * 因为TABLE_PER_CLASS策略每个表都是单独的，没有并且各表的主键没有任何关系，所以不能使用GenerationType.AUTO或GenerationType.IDENTITY
     * 主键生成策略，可以使用GenerationType.TABLE。
     */
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Enumerated(STRING)
    private UserType discriminator;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别(0:男 1:女 2:其他)
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 状态(0:有效 1:冻结)
     */
    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


}
