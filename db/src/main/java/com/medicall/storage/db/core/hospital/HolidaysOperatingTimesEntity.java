package com.medicall.storage.db.core.hospital;

import com.medicall.domain.hospital.OperatingTime;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class HolidaysOperatingTimesEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital", nullable = false)
    private HospitalEntity hospital;

    @Column(nullable = false)
    private LocalDate date;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private LocalTime breakStartTime;

    private LocalTime breakFinishTime;

    @Column(nullable = false)
    private boolean isClosed;

    public boolean isClosed() {
        return isClosed;
    }

    public LocalTime getBreakFinishTime() {
        return breakFinishTime;
    }

    public LocalTime getBreakStartTime() {
        return breakStartTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public HospitalEntity getHospital() {
        return hospital;
    }

    protected HolidaysOperatingTimesEntity() {}

    public HolidaysOperatingTimesEntity(LocalDate date, LocalTime openingTime, LocalTime closingTime,
                                        LocalTime breakStartTime, LocalTime breakFinishTime, boolean isClosed){
        this.date = date;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.breakStartTime = breakStartTime;
        this.breakFinishTime = breakFinishTime;
        this.isClosed = isClosed;
    }

    public void addHospital(HospitalEntity hospital){
        this.hospital = hospital;
    }

    public OperatingTime toDomainModel(){
        return new OperatingTime(
                this.date.getDayOfWeek(),
                this.isClosed,
                this.openingTime,
                this.closingTime,
                this.breakStartTime,
                this.breakFinishTime
        );
    }
}
