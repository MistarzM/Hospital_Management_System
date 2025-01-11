"use client"
 
import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { Button } from "@/components/ui/button"
import { Form, FormControl } from "@/components/ui/form"
import CustomFormField from "../CustomFormField"
import SubmitButton from "../SubmitButton"
import { useState } from "react"
import { TriageFormValidation, UserFormValidation, VisitFormValidation } from "@/lib/validation"
import { useRouter } from "next/navigation"
import { createUser } from "@/lib/actions/patient.actions"
import { FormFieldType } from "./PatientForm"
import { RadioGroup } from "@radix-ui/react-radio-group"
import axios from "axios"
import { submitTriageData, updateVisitStatus } from "@/lib/actions/triage.actions"
 
const VisitForm = ({
    id,
    hospitalizationSteps,
    prescription,
    triageId,
} : {
    id : number;
    hospitalizationSteps : string;
    prescription : string;
    triageId : number;
}) => {
    const router = useRouter();
    const [isLoading, setIsLoading] = useState(false)

    const form = useForm<z.infer<typeof VisitFormValidation>>({
        resolver: zodResolver(VisitFormValidation),
        defaultValues: {
            hospitalizationSteps: hospitalizationSteps ? hospitalizationSteps : "",
            prescription: prescription ? prescription : "", 
        },
      });
    
      async function onSubmit({
        hospitalizationSteps,
        prescription,
      }: z.infer<typeof VisitFormValidation>) {
        setIsLoading(true);

    try {
      const data = {
        id,
        hospitalizationSteps,
        prescription,
        triageId,
      };
      await updateVisitStatus(data);
      router.push('/er/queue');
    } catch (error) {
        console.log(error)
    }
    setIsLoading(false)
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6 flex-1">
        <CustomFormField
            fieldType={FormFieldType.TEXTBIGAREA}
            control={form.control}
            name="hospitalizationSteps"
            label="Hospitalization Steps"
            placeholder="Step1 ..."
        />
        <CustomFormField 
            fieldType={FormFieldType.TEXTBIGAREA}
            control={form.control}
            name="prescription"
            label="Prescription"
            placeholder="Prescription: ..."
        />
        <SubmitButton isLoading={ isLoading }>Submit</SubmitButton>
      </form>
    </Form>
  )
}

export default VisitForm