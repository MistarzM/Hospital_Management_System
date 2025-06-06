"use client";

import { ColumnDef } from "@tanstack/react-table";
import {  Queue } from "@/types/appwrite.types";
import StatusBadge from "../StatusBadge";
import { QueueResultModal } from "../QueueResultModal";
import { QueueFinishModal } from "../QueueFinishModal";

export const columns: ColumnDef<Queue>[] = [
  {
    header: "Queue",
    cell: ({ row }) => {
      return <p className="text-14-medium text-dark-600">{row.index + 1}</p>
    },
  },
  {
    accessorKey: "triageId",
    header: "Triage ID",
    cell: ({ row }) => {
      const queue = row.original;
      return <p className="text-14-medium ">{queue.triageId}</p>
    },
  },
  {
    accessorKey: "priorityLevel",
    header: "Priority points",
    cell: ({ row }) => {
      const queue = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
           <p className="text-14-medium ">{queue.priorityLevel}</p>
        </p>
      );
    },
  },
  {
    accessorKey: "priorityPoints",
    header: "Priority points",
    cell: ({ row }) => {
      const queue = row.original;
      return (
        <p className="text-14-regular min-w-[100px]">
           <p className="text-14-medium ">{queue.priorityPoints}</p>
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
          <p className="text-14-medium ">{queue.status}</p>
        </p>
      );
    },
  },
  {
    id: "result",
    header: () => <div className="pl-4">Result</div>,
    cell: ({ row }) => {
      const queue = row.original;

      return (
        <div className="flex gap-1">
          <QueueResultModal
            id = {queue.id}
            triageId = {queue.triageId} 
            priorityLevel = {queue.priorityLevel}
            priorityPoints = {queue.priorityPoints}
            status = {queue.status}
          />
          <QueueFinishModal
            id = {queue.id}
            triageId = {queue.triageId} 
            priorityLevel = {queue.priorityLevel}
            priorityPoints = {queue.priorityPoints}
            status = {queue.status}
          />
        </div>
      );
    },
  },
];