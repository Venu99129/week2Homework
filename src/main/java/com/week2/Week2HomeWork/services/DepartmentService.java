package com.week2.Week2HomeWork.services;

import com.week2.Week2HomeWork.Exceptions.ResourceNotFoundException;
import com.week2.Week2HomeWork.dtos.DepartmentDto;
import com.week2.Week2HomeWork.entitys.DepartmentEntity;
import com.week2.Week2HomeWork.repositorys.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapper){
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> fetchedDepartments = departmentRepository.findAll()
                .stream()
                .map(departmentEntity -> mapper.map(departmentEntity, DepartmentDto.class)).toList();
        return fetchedDepartments;
    }

    private void isExistsDepartmentWithId(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFoundException("department not found with id :"+departmentId);
    }

    public DepartmentDto getDepartmentById(Long departmentId) {
        isExistsDepartmentWithId(departmentId);
        return mapper.map(departmentRepository.findById(departmentId).get() , DepartmentDto.class);
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity savingEntity = mapper.map(departmentDto , DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(savingEntity);
        return mapper.map(savedEntity , DepartmentDto.class);
    }

    public DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto) {
        isExistsDepartmentWithId(departmentId);
        DepartmentEntity entity = mapper.map(departmentDto , DepartmentEntity.class);
        return mapper.map(departmentRepository.save(entity), DepartmentDto.class);
    }

    public Boolean deleteDepartmentById(Long departmentId) {
        isExistsDepartmentWithId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
