package com.ums.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "OfficeBranch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OfficeBranch extends Base {
    @NotEmpty
    @Column(unique = true)
    private String branchName;

    @NotEmpty
    @Column(unique = true)
    private String branchCode;
    @ManyToOne
    @JoinColumn(name = "office_id")
    @JsonIgnore
    private Office office;
    @OneToMany(mappedBy = "officeBranch")
    @JsonIgnore
    private List<Employee> employees=new ArrayList<>();
}
