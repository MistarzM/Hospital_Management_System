"use client";

import { ColumnDef } from "@tanstack/react-table";
import {  Queue } from "@/types/appwrite.types";
import StatusBadge from "../StatusBadge";

export const columns: ColumnDef<Queue>[] = [
  {
    header: "#",
    cell: ({ row }) => {
      return <p className="text-14-medium ">{row.id + 1}</p>;
    },
  },
  {
    accessorKey: "triage_id",
    header: "Triage ID",
    cell: ({ row }) => {
      const queue = row.original;
      return <p className="text-14-medium ">{queue.triage_id}</p>;
    },
  },
  {
    accessorKey: "priority_level",
    header: "Priority points",
    cell: ({ row }) => {
      const queue = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{queue.priority_level}</p>;
        </p>
      );
    },
  },
  {
    accessorKey: "priority_points",
    header: "Priority points",
    cell: ({ row }) => {
      const queue = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{queue.priority_points}</p>;
        </p>
      );
    },
  },
  {
    accessorKey: "status",
    header: "Status",
    cell: ({ row }) => {
      const queue = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
          eturn <p className="text-14-medium ">{queue.status}</p>;
        </p>
      );
    },
  },
];