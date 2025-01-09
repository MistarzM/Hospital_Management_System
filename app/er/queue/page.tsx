"use client"
import Image from "next/image";
import Link from "next/link";
import { DataTable } from "@/components/queue/DataTable";
import StatCard from "@/components/StatCard";
import { useEffect, useState } from "react";
import { ColumnDef } from "@tanstack/react-table";
import { listQueue } from "@/lib/actions/triage.actions";
import type { Queue } from "@/types/appwrite.types";
import { columns } from "@/components/queue/columns";

const Queue = () => {
    const [que, setQueue] = useState<Queue[]>([]);
  
    useEffect(() => {
      listQueue()
        .then((data) => {
          setQueue(data);
        })
        .catch((error) => {
          console.error(error);
        });
    }, []);
  
  return (
    <div className="mx-auto flex max-w-7xl flex-col space-y-14">
      <header className="admin-header">
        <Link href="/er" className="cursor-pointer">
          <Image
            src="/assets/images/logo-full.png"
            height={32}
            width={162}
            alt="logo"
            className="h-8 w-fit"
          />
        </Link>
        <h1 className="text-blue-500 font-extrabold text-4xl">EHospital</h1>
        <p className="text-16-semibold">Triage Dashboard</p>
      </header>

      <main className="admin-main">
        <DataTable columns={columns} data={que} />
      </main>
    </div>
  );
};

export default Queue;