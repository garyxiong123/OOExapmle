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
 *
 *不管超类是抽象类还是具体类，都会生成对应的表。
二、联合子类策略
这种策略超类会被映射成一个单独的表，每个子类也会映射成一个单独的表。子类对应的表中只包括自身属性对应的字段，默认情况下使用主键作为超类对应的表的外键。
这种策略对于实体间的多态关系提供了很好的支持。但缺点是实例化子类实例时需要一个或多个表的关联操作。在深层次的继承结构中，这会导致性能很
 *
 */



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length = 30)
public class User {

//其中，超类的@DiscriminatorColumn注解可以省略，默认的“discriminator列”名为DTYPE，默认类型为STRING。

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();



}
