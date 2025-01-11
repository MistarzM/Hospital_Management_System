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
import { fetchVisitInfo, updateTriageStatus } from "@/lib/actions/triage.actions";
import { useRouter } from "next/navigation";

export const QueueFinishModal = ({
  id,
  triageId,
  priorityLevel,
  priorityPoints, 
  status 
}: {
  id: number;
  triageId: number;
  priorityLevel: string; 
  priorityPoints: number; 
  status: string; 
}) => {
    const [open, setOpen] = useState(false);
    const [info, setInfo] = useState<{ hospitalizationSteps: string; prescription: string } | null>(null);
    const router = useRouter();
  
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

    
      const handleOpenChange = async (isOpen: boolean) => {
        setOpen(isOpen);
        if (isOpen) {
          const data = {
            id,
            triageId,
            priorityLevel,
            priorityPoints,
            status: "FINISH"
          };
          try {
            await updateTriageStatus(data);
          } catch (error) {
            console.error('Error updating status:', error);
          }
        } else {
            router.refresh();
            window.location.reload();
        }
      };

  return (
     <Dialog open={open} onOpenChange={handleOpenChange}>
      <DialogTrigger asChild>
        <Button
          variant="ghost"
          className={"text-red-500"}
        >
          finish
        </Button>
      </DialogTrigger>
      <DialogContent className="shad-dialog sm:max-w-3xl">
        <DialogHeader className="mb-4 space-y-3">
          <DialogTitle className="text-32-bold capitalize">Result</DialogTitle>
          <DialogDescription>
            {info ? (
              <>
                <h5 className="text-18-bold text-black">FINISHED</h5>
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