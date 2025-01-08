"use client"
 
import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { Button } from "@/components/ui/button"
import { Form, FormControl } from "@/components/ui/form"
import CustomFormField from "../CustomFormField"
import SubmitButton from "../SubmitButton"
import { useState } from "react"
import { TriageFormValidation, UserFormValidation } from "@/lib/validation"
import { useRouter } from "next/navigation"
import { createUser } from "@/lib/actions/patient.actions"
import { FormFieldType } from "./PatientForm"
import { RadioGroup } from "@radix-ui/react-radio-group"
 
const PatientForm = () => {
    const router = useRouter();
    const [isLoading, setIsLoading] = useState(false)

    const form = useForm<z.infer<typeof TriageFormValidation>>({
        resolver: zodResolver(TriageFormValidation),
        defaultValues: {
          name: "",
          birthDate: new Date(Date.now()),
          bloodPressure: "0",
          heartRate: "0",
          oxygenSaturation: "0",
          conditionDescription: "",
        },
      });
    
      async function onSubmit({
        name,
        birthDate,
        bloodPressure,
        heartRate,
        oxygenSaturation,
        conditionDescription,
      }: z.infer<typeof TriageFormValidation>) {
        setIsLoading(true);

    try {
        router.push(`/er/table`)
    } catch (error) {
        console.log(error)
    }
    setIsLoading(false)
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6 flex-1">
        <section className="mb-12 space-y-4">
            <h1 className="header"> Emergency Room </h1>
            <p className="text-dark-700">Triage</p>
        </section>

        <CustomFormField
            fieldType={FormFieldType.INPUT}
            control={form.control}
            name="name"
            label="Full name"
            placeholder="Michal Mistarz"
            iconSrc="/assets/icons/user.svg"
            iconAlt="user"
        />

        <div className="flex flex-col gap-6 xl:flex-row">
            <CustomFormField
                fieldType={FormFieldType.DATE_PICKER}
                control={form.control}
                name="birthDate"
                label="Date of birth"
            />

            <CustomFormField
                fieldType={FormFieldType.INPUT}
                control={form.control}
                name="bloodPressure"
                label="Blood pressure"
                placeholder="0"
            />
        </div>

        <div className="flex flex-col gap-6 xl:flex-row">
            <CustomFormField
                fieldType={FormFieldType.INPUT}
                control={form.control}
                name="heartRate"
                label="Heart Rate"
                placeholder="mid"
            />

            <CustomFormField
                fieldType={FormFieldType.INPUT}
                control={form.control}
                name="oxygenSaturation"
                label="Oxygen Saturation"
                placeholder="0"
            />
        </div>

        <CustomFormField
            fieldType={FormFieldType.TEXTAREA}
            control={form.control}
            name="conditionDescription"
            label="Condition Description"
            placeholder="ChestPain"
        />
        <SubmitButton isLoading={ isLoading }>Get Started</SubmitButton>
      </form>
    </Form>
  )
}

export default PatientForm