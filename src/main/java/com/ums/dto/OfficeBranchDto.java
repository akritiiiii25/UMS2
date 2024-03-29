package com.ums.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OfficeBranchDto
{

    private String branchName;
    private String branchCode;
    private String officeId;
    private List<String> officeBranchIds;

}