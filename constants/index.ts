export const GenderOptions = ["male", "female", "other"];

export const PatientFormDefaultValues = {
  firstName: "",
  lastName: "",
  email: "",
  phone: "",
  birthDate: new Date(Date.now()),
  gender: "male" as Gender,
  address: "",
  occupation: "",
  emergencyContactName: "",
  emergencyContactNumber: "",
  primaryPhysician: "",
  insuranceProvider: "",
  insurancePolicyNumber: "",
  allergies: "",
  currentMedication: "",
  familyMedicalHistory: "",
  pastMedicalHistory: "",
  identificationType: "Birth Certificate",
  identificationNumber: "",
  identificationDocument: [],
  treatmentConsent: false,
  disclosureConsent: false,
  privacyConsent: false,
};

export const IdentificationTypes = [
  "Birth Certificate",
  "Driver's License",
  "Medical Insurance Card/Policy",
  "National Identity Card",
  "Passport",
  "Student ID Card",
];

export const Doctors = [
  {
    image: "/assets/images/dr-lisowska.png",
    name: "Sara Lisowska",
  },
  {
    image: "/assets/images/dr-kowal.png",
    name: "Karolina Kowalska",
  },
  {
    image: "/assets/images/dr-krol.png",
    name: "Mariusz Krol",
  },
  {
    image: "/assets/images/dr-marcisz.png",
    name: "Martyna Marcisz",
  },
  {
    image: "/assets/images/dr-podolski.png",
    name: "Lukasz Podolski",
  },
  {
    image: "/assets/images/dr-zagorski.png",
    name: "Michal Zagorski",
  },
];

export const StatusIcon = {
  scheduled: "/assets/icons/check.svg",
  pending: "/assets/icons/pending.svg",
  cancelled: "/assets/icons/cancelled.svg",
};