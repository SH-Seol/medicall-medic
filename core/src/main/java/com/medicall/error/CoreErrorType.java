package com.medicall.error;

public enum CoreErrorType {
    HOSPITAL_NOT_FOUND(CoreErrorCode.HOSPITAL001, CoreErrorKind.NOT_FOUND, "존재하지 않는 병원입니다.", CoreErrorLevel.WARN),
    PATIENT_NOT_FOUND(CoreErrorCode.HOSPITAL001, CoreErrorKind.NOT_FOUND, "존재하지 않는 환자입니다.", CoreErrorLevel.WARN),
    DOCTOR_NOT_FOUND(CoreErrorCode.HOSPITAL001, CoreErrorKind.NOT_FOUND, "존재하지 않는 의사입니다.", CoreErrorLevel.WARN),
    DEPARTMENT_NOT_FOUND(CoreErrorCode.DEPARTMENT001, CoreErrorKind.NOT_FOUND, "존재하지 않는 전공입니다.", CoreErrorLevel.WARN),
    APPOINTMENT_NOT_FOUND(CoreErrorCode.APPOINTMENT001, CoreErrorKind.NOT_FOUND, "존재하지 않는 예약입니다.", CoreErrorLevel.WARN),
    ;
    private final CoreErrorCode errorCode;
    private final CoreErrorKind errorKind;
    private final String message;
    private final CoreErrorLevel errorLevel;

    CoreErrorType(CoreErrorCode errorCode, CoreErrorKind errorKind, String message, CoreErrorLevel errorLevel) {
        this.errorCode = errorCode;
        this.errorKind = errorKind;
        this.message = message;
        this.errorLevel = errorLevel;
    }

    public CoreErrorCode getErrorCode() {
        return errorCode;
    }

    public CoreErrorKind getErrorKind() {
        return errorKind;
    }

    public String getMessage() {
        return message;
    }

    public CoreErrorLevel getErrorLevel() {
        return errorLevel;
    }
}
