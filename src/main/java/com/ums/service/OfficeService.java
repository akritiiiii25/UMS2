package com.ums.service;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.repository.IOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    @Autowired
    private IOffice officeRepository;

    public Office createOffice(OfficeDto officeDto) {
        Office office = new Office();
        office.setOfficeName(officeDto.getOfficeName());
        office.setRegion(officeDto.getRegion());
        return officeRepository.save(office);
    }


}

