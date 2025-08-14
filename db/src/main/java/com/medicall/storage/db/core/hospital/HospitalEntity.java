package com.medicall.storage.db.core.hospital;

import com.medicall.domain.hospital.Hospital;
import com.medicall.storage.db.core.address.AddressEntity;
import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.domain.common.enums.BusinessStatus;
import com.medicall.storage.db.core.common.enums.RegistrationStatus;
import com.medicall.storage.db.core.department.DepartmentEntity;
import com.medicall.storage.db.core.department.HospitalDepartmentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HospitalEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String telephoneNumber;

    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<HospitalDepartmentEntity> departments = new ArrayList<>();

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<AppointmentEntity> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OperatingTimesEntity> operatingTimes = new ArrayList<>();

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<HolidaysOperatingTimesEntity> holidaysOperatingTimes = new ArrayList<>();

    @Column(nullable = false)
    private RegistrationStatus registrationStatus;

    @Transient
    @Enumerated(EnumType.STRING)
    private BusinessStatus businessStatus;

    protected HospitalEntity() {}

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public HospitalEntity(String name, String telephoneNumber, AddressEntity address, String imageUrl) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.imageUrl = imageUrl;
        this.registrationStatus = RegistrationStatus.PENDING;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public List<HospitalDepartmentEntity> getDepartments() {
        return departments;
    }

    public List<OperatingTimesEntity> getOperatingTimes() {
        return operatingTimes;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public List<HolidaysOperatingTimesEntity> getHolidaysOperatingTimes() {
        return holidaysOperatingTimes;
    }

    public BusinessStatus getBusinessStatus() {
        return businessStatus;
    }

    public void addDepartments(List<DepartmentEntity> departments) {
        departments.forEach(this::addDepartment);
    }

    public void addDepartment(DepartmentEntity department) {
        HospitalDepartmentEntity hospitalDepartmentEntity = new HospitalDepartmentEntity(this, department);
        departments.add(hospitalDepartmentEntity);
    }

    public void addOperatingTimes(List<OperatingTimesEntity> operatingTimes) {
        operatingTimes.forEach(this::addOperatingTime);
    }

    public void addOperatingTime(OperatingTimesEntity operatingTime) {
        operatingTimes.add(operatingTime);
    }

    public Hospital toDomainModel(){
        return new Hospital(
                this.id,
                this.name,
                this.telephoneNumber,
                this.address.toDomainModel(),
                this.imageUrl,
                this.departments.stream().map(HospitalDepartmentEntity::getDepartment).map(DepartmentEntity::toDomainModel).toList(),
                this.operatingTimes.stream().map(OperatingTimesEntity::toDomainModel).toList(),
                this.businessStatus
        );
    }
}
