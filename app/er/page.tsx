import PatientForm from "@/components/forms/PatientForm"
import TriageForm from "@/components/forms/TriageForm";
import { PasskeyModal } from "@/components/PasskeyModal";
import { Button } from "@/components/ui/button"
import Image from "next/image"
import Link from "next/link"

export default function EmergencyRoom({ searchParams }: SearchParamProps) {
  const isAdmin = searchParams?.admin === 'true';

  return (
    <div className="flex h-screen max-h-screen">
      <Image
        src="/assets/images/onboarding-img.png"
        height={1000}
        width={1000}
        alt="patient"
        className="side-img max-w-[60%]"
      />

      {isAdmin && <PasskeyModal />}
      <section className="remove-scrollbar container my-auto">
        <div className="sub-container max-w-[496px]">
          <div className="flex flex-col gap-6 xl:flex-row">
            <Image
              src="/assets/icons/logo-full.svg"
              height={1000}
              width={1000}
              alt="patient"
              className="mb-12 h-10 w-fit"
            />
            <Link href="/">
              <Button className=" shad-primary-btn w-3/5 ml-24">
                Home - Hospital
              </Button>
            </Link>
          </div>
          <TriageForm />
          <div className="text-14-regular mt-20 flex justify-between">
            <p className="justify-items-end text-dark-600 xl:text-left">
              © 2025 EHM 
            </p> 
          </div>
        </div>
      </section>
    </div>
  )
}
