"use client";

import { useEffect, useState } from "react";

import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Queue } from "@/types/appwrite.types";

import { AppointmentForm } from "./forms/AppointmentForm";

import "react-datepicker/dist/react-datepicker.css";
import { fetchVisitInfo } from "@/lib/actions/triage.actions";

export const QueueResultModal = ({
  id,
  triageId,
}: {
  id: number;
  triageId: number;
}) => {
    const [open, setOpen] = useState(false);
    const [info, setInfo] = useState<{ hospitalizationSteps: string; prescription: string } | null>(null);
  
    useEffect(() => {
      const fetchInfo = async () => {
        try {
          const data = await fetchVisitInfo(triageId);
          setInfo(data);
        } catch (error) {
          console.error('Error fetching info:', error);
        }
      };
  
      fetchInfo();
    }, [triageId]);

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>
        <Button
          variant="ghost"
          className={"text-green-500"}
        >
          Info
        </Button>
      </DialogTrigger>
      <DialogContent className="shad-dialog sm:max-w-3xl">
        <DialogHeader className="mb-4 space-y-3">
          <DialogTitle className="text-32-bold capitalize">Result</DialogTitle>
          <DialogDescription>
            {info ? (
              <>
                <h5 className="text-18-bold text-black">Hospitalization Steps:</h5>
                <div dangerouslySetInnerHTML={{ __html: info.hospitalizationSteps }} />
                <h5 className="text-18-bold text-black">Prescription:</h5>
                <div>{info.prescription}</div>
              </>
            ) : (
              <div>'Loading...'</div>
            )}
          </DialogDescription>
        </DialogHeader>

      </DialogContent>
    </Dialog>
  );
};