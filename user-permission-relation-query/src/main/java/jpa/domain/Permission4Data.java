package jpa.domain;

import jpa.domain.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("data")
public class Permission4Data extends Permission {

    private String tableName;

    private String columnName;


}
