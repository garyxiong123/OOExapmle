package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: @NamedEntityGraph的使用时为了解决sql查询过多的问题
 *
 * 当去查询person的时候会自动查询Adress和Cards里面的内容，且只发出一条sql语句，这样就解决了是使用关联查询导致sql查询过多的问题
 *
 * @Date: 2020/2/9 下午9:33
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@NamedEntityGraph(name = "person.all", attributeNodes = {@NamedAttributeNode(value = "address"), @NamedAttributeNode("cards")})
public class Person {
    /**
     * select person0_.id as id1_2_0_, address1_.id as id1_0_1_, card3_.id as id1_1_2_, person0_.address_id
     * as address_4_2_0_, person0_.age as age2_2_0_, person0_.username as username3_2_0_, address1_.address_name as
     * address_2_0_1_, card3_.card_name as card_nam2_1_2_, cards2_.p_id as p_id1_3_0__, cards2_.c_id as c_id2_3_0__
     * from person person0_ left outer join address address1_ on person0_.address_id=address1_.id left outer join s_person_card cards2_ on person0_.id=cards2_.p_id left outer join card card3_ on cards2_.c_id=card3_.id where person0_.id=?
     */
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    private String id;
    private String username;
    private String age;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "s_person_card", joinColumns = {@JoinColumn(name = "p_id")}
            , inverseJoinColumns = {@JoinColumn(name = "c_id")})
    private List<Card> cards;


}
