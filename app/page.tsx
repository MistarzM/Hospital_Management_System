import PatientForm from "@/components/forms/PatientForm"
import { PasskeyModal } from "@/components/PasskeyModal";
import { Button } from "@/components/ui/button"
import Image from "next/image"
import Link from "next/link"

export default function Home({ searchParams }: SearchParamProps) {
  const isAdmin = searchParams?.admin === 'true';

  return (
    <div className="flex h-screen max-h-screen">
      <Image
        src="/assets/images/onboarding-img.jpg"
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
            <Link href="/er">
              <Button className=" shad-primary-btn w-3/5 ml-24">
                Emergency Room
              </Button>
            </Link>
          </div>
          <PatientForm />
          <div className="text-14-regular mt-20 flex justify-between">
            <p className="justify-items-end text-dark-600 xl:text-left">
              © 2025 EHM 
            </p> 
            <Link href="/?admin=true" className="text-dark-500">
              Admin  
            </Link>
          </div>
        </div>
      </section>
    </div>
  )
}
