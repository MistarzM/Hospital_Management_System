"use client";

import { ColumnDef } from "@tanstack/react-table";
import Image from "next/image";

import { Doctors } from "@/constants";
import { formatDateTime } from "@/lib/utils";
import {  Triage } from "@/types/appwrite.types";

import { AppointmentModal } from "../AppointmentModal";
import StatusBadge from "../StatusBadge";

export const columns: ColumnDef<Triage>[] = [
  {
    header: "#",
    cell: ({ row }) => {
      return <p className="text-14-medium ">{row.id + 1}</p>;
    },
  },
  {
    accessorKey: "name",
    header: "Patient",
    cell: ({ row }) => {
      const triage = row.original;
      return <p className="text-14-medium ">{triage.name}</p>;
    },
  },
  {
    accessorKey: "status",
    header: "Status",
    cell: ({ row }) => {
      const triage = row.original;
      return (
        <div className="min-w-[115px]">
        </div>
      );
    },
  },
  {
    accessorKey: "date",
    header: "Date",
    cell: ({ row }) => {
      const triage = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          {formatDateTime(triage.date).dateTime}
        </p>
      );
    },
  },
  {
    accessorKey: "heart_rate",
    header: "Heart Rate",
    cell: ({ row }) => {
      const triage = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{triage.heartRate}</p>;
        </p>
      );
    },
  },
  {
    accessorKey: "oxygen_saturation",
    header: "Oxygen Saturation",
    cell: ({ row }) => {
      const triage = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{triage.oxygenSaturation}</p>;
        </p>
      );
    },
  },
  {
    accessorKey: "blood_pressure",
    header: "Blood Pressure",
    cell: ({ row }) => {
      const triage = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{triage.bloodPressure}</p>;
        </p>
      );
    },
  },
];