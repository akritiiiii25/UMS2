package com.ums.service;

import com.ums.dto.OfficeDto;
import com.ums.entity.Office;
import com.ums.repository.IOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OfficeService
{
    private final IOffice officeRepository;
    @Autowired
    public OfficeService(IOffice officeRepository)
    {
        this.officeRepository = officeRepository;
    }
    public Office createOffice(OfficeDto officeDto)
    {
        boolean officeExists = officeRepository.existsByOfficeNameAndRegion(officeDto.getOfficeName(), officeDto.getRegion());
        if (officeExists)
        {
            throw new RuntimeException("Office with provided details already exists");
        }
        Office office = new Office();
        office.setOfficeName(officeDto.getOfficeName());
        office.setRegion(officeDto.getRegion());

        return officeRepository.save(office);
    }
}
