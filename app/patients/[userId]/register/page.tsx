import RegisterForm from '@/components/forms/RegisterForm'
import { getUser } from '@/lib/actions/patient.actions'
import Image from 'next/image'
import React from 'react'
import * as Sentry from '@sentry/nextjs'

const Register = async ({ params: { userId }}: SearchParamProps) => {
  const user = await getUser(userId);

  Sentry.metrics.set("user_view_register", user.name);

  return (
    <div className="flex h-screen max-h-screen">
      <section className="remove-scrollbar container">
        <div className="sub-container max-w-[860px] flex-1 flex-col py-10">
        <div className="flex items-center mb-12">
            <Image
              src="/assets/images/logo-full.png"
              height={1200}
              width={1200}
              alt="patient"
              className="h-10 w-fit"
            />
            <h1 className="text-blue-500 font-extrabold text-4xl ml-4">EHospital</h1> 
          </div>
          <RegisterForm user={user} /> 
        <p className="copyright py-12">
            © 2025 EHM 
        </p> 
        </div>
      </section>
      <Image
        src="/assets/images/register-bg.jpg"
        height={1000}
        width={1000}
        alt="patient"
        className="side-img max-w-[400px]"
      />
    </div>
  )
}

export default Register  