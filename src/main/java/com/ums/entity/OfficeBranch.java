package com.ums.entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name="OfficeBranch")
@NoArgsConstructor
@AllArgsConstructor
public class OfficeBranch extends Base {

    @NotEmpty(message = "Branch name :")
    @Column(unique = true)
    private String branchName;

    @NotEmpty(message = "Branch code :")
    @Column(unique = true)
    private String branchCode;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @OneToMany(mappedBy = "officeBranch")
    private List<Employee> employees = new ArrayList<>();
}
