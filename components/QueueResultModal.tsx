"use client";

import { useState } from "react";

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

export const QueueResultModal = ({
  id,
  triageId,
  priorityPoints,
  priorityLevel,
  status
}: {
  id: number;
  triageId: number;
  priorityPoints: number;
  priorityLevel: string;
  status: string;
}) => {
  const [open, setOpen] = useState(false);

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>
        <Button
          variant="ghost"
          className={"text-green-500"}
        >
          Result
        </Button>
      </DialogTrigger>
      <DialogContent className="shad-dialog sm:max-w-md">
        <DialogHeader className="mb-4 space-y-3">
          <DialogTitle className="capitalize">Result</DialogTitle>
          <DialogDescription>
            Its Result
          </DialogDescription>
        </DialogHeader>

      </DialogContent>
    </Dialog>
  );
};