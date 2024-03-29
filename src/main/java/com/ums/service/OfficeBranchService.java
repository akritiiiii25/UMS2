package com.ums.service;
import com.ums.dto.OfficeBranchDto;
import com.ums.entity.Office;
import com.ums.entity.OfficeBranch;
import com.ums.repository.IOffice;
import com.ums.repository.IOfficeBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OfficeBranchService
{
    private final IOfficeBranch officeBranchRepository;
    private final IOffice officeRepository;
    @Autowired
    public OfficeBranchService(IOfficeBranch officeBranchRepository, IOffice officeRepository) {
        this.officeBranchRepository = officeBranchRepository;
        this.officeRepository = officeRepository;

    private IOfficeBranch officeBranchRepository;

    public OfficeBranch createOfficeBranch(OfficeBranchDto officeBranchDto) {
        OfficeBranch officeBranch = new OfficeBranch();
        officeBranch.setBranchName(officeBranchDto.getBranchName());
        officeBranch.setBranchCode(officeBranchDto.getBranchCode());

        return officeBranchRepository.save(officeBranch);
    }
        public ResponseEntity<?> createOfficeBranch(OfficeBranchDto officeBranch)
        {
        boolean officeBranchExists = officeBranchRepository.existsByBranchNameAndOffice_Id( officeBranch.getBranchName(), officeBranch.getOfficeId());
        if (officeBranchExists)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Office branch already exists.");
        }

        OfficeBranch newOfficeBranch = new OfficeBranch();
        Optional<Office> office = officeRepository.findById(officeBranch.getOfficeId());
        office.ifPresent(newOfficeBranch::setOffice);
        newOfficeBranch.setBranchName(officeBranch.getBranchName());
        newOfficeBranch.setBranchCode(officeBranch.getBranchCode());

        OfficeBranch createdOfficeBranch = officeBranchRepository.save(newOfficeBranch);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOfficeBranch);
    }
}

