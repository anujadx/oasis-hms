package com.oasis.ui;

import org.jetbrains.annotations.Contract;

public enum UIName {
    DASHBOARD("/com/oasis/ui/view/main/Dashboard.fxml"),

    //Sidebar
    LAUNCHER("/com/oasis/ui/view/main/Launcher.fxml"),
    EMPLOYEE_SIDEBAR("/com/oasis/ui/view/employee/EmployeeSideBar.fxml"),
    PHYSICIAN_SIDEBAR("/com/oasis/ui/view/physician/PhysicianSideBar.fxml"),
    PATIENT_SIDEBAR("/com/oasis/ui/view/patient/PatientSideBar.fxml"),
    ADMISSION_SIDEBAR("/com/oasis/ui/view/admission/AdmissionSideBar.fxml"),
    PAYMENT_SIDEBAR("/com/oasis/ui/view/payment/PaymentSideBar.fxml"),
    MEDICAL_SIDEBAR("/com/oasis/ui/view/medical/MedicalSideBar.fxml"),
    ADMINISTRATION_SIDEBAR("/com/oasis/ui/view/administration/AdministrationSideBar.fxml"),
    REPORTS_SIDEBAR("/com/oasis/ui/view/reports/ReportsSideBar.fxml"),
    SETTINGS_SIDEBAR("/com/oasis/ui/view/settings/SettingsSideBar.fxml"),

    //Physician
    NEW_PHYSICIAN("/com/oasis/ui/view/physician/NewPhysician.fxml"),
    PHYSICIAN_MANAGEMENT("/com/oasis/ui/view/physician/PhysicianManagement.fxml"),

    //Admission
    NEW_ADMISSION("/com/oasis/ui/view/admission/NewAdmission.fxml"),
    ADMISSION_MANAGEMENT("/com/oasis/ui/view/admission/AdmissionManagement.fxml"),

    //Payment
    NEW_PAYMENT("/com/oasis/ui/view/payment/NewPayment.fxml"),
    PAYMENT_MANAGEMENT("/com/oasis/ui/view/payment/PaymentManagement.fxml"),

    //Patient
    NEW_RACE("/com/oasis/ui/view/patient/NewRace.fxml"),
    RACE_MANAGEMENT("/com/oasis/ui/view/patient/RaceManagement.fxml"),
    NEW_ETHNICITY("/com/oasis/ui/view/patient/NewEthnicity.fxml"),
    ETHNICITY_MANAGEMENT("/com/oasis/ui/view/patient/EthnicityManagement.fxml"),
    NEW_TREATMENT("/com/oasis/ui/view/patient/NewTreatment.fxml"),
    TREATMENT_MANAGEMENT("/com/oasis/ui/view/patient/TreatmentManagement.fxml"),
    NEW_PATIENT("/com/oasis/ui/view/patient/NewPatient.fxml"),
    PATIENT_MANAGEMENT("/com/oasis/ui/view/patient/PatientManagement.fxml"),

    //Employee
    NEW_SPECIALITY("/com/oasis/ui/view/employee/NewSpeciality.fxml"),
    SPECIALITY_MANAGEMENT("/com/oasis/ui/view/employee/SpecialityManagement.fxml"),
    NEW_EMPLOYEE("/com/oasis/ui/view/employee/NewEmployee.fxml"),
    EMPLOYEE_MANAGEMENT("/com/oasis/ui/view/employee/EmployeeManagement.fxml"),
    SUBMIT_ATTENDANCE("/com/oasis/ui/view/employee/SubmitAttendance.fxml"),
    ATTENDANCE_MANAGEMENT("/com/oasis/ui/view/employee/AttendanceManagement.fxml"),

    //Medical
    NEW_TEST("/com/oasis/ui/view/medical/NewTest.fxml"),
    TEST_MANAGEMENT("/com/oasis/ui/view/medical/TestManagement.fxml"),

    //Administration
    NEW_WARD("/com/oasis/ui/view/administration/NewWard.fxml"),
    WARD_MANAGEMENT("/com/oasis/ui/view/administration/WardManagement.fxml");

    private final String location;

    UIName(String location) {
        this.location = location;
    }

    @Contract(pure = true)
    public String getLocation() {
        return location;
    }
}
